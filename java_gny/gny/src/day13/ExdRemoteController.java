package day13;
//리모콘기능 만들어보자
public interface ExdRemoteController {
	
	//1 전원기능
	public void powerOn();
	public void powerOff();

	
}

interface ExdTvReomoteController extends ExdRemoteController{
	public void volumeUp();
	public void volumeDown();
	public void channelUp();
	public void channelDown();
	public void changeChannel(int num);
	
}
class ExdTvReomoteCon implements ExdTvReomoteController{
//	public final static String LOGO = "LG";
	//static은 어떤때 쓰는걸까... static 추가하니까 갑자기 LOGO가 기울어짐..
	private boolean power = false;//TV전원상태
	private int channel = 1;
	private int volume = 0;
	private final int maxChannel;
	private final int maxVolume;

	@Override
	public void powerOn() {
		power = true;
		System.out.println("전원이 켜졌습니다");
	}

	@Override
	public void powerOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다");
	}
	
	@Override
	public void volumeUp() {
		if(!power) return; //TV가 꺼져있으면 볼륨을 올릴 수 없음
		++volume;
		volume = volume>maxVolume?maxVolume:volume;
		System.out.println("소리 : "+volume);
	}
	
	@Override
	public void volumeDown() {
		if(!power) return; //TV가 꺼져있으면 볼륨을 올릴 수 없음
		--volume;
		volume = volume<0?0:volume;
		System.out.println("소리 : "+volume);
	}

	@Override
	public void channelUp() {
		if(!power) return;
		++channel;
		channel = channel>maxChannel?maxChannel:channel;
		System.out.println("채널 : "+channel);
		
	}

	@Override
	public void channelDown() {
		if(!power) return;
		--channel;
		channel = channel<0?0:channel;
		System.out.println("채널 : "+channel);
		
		
	}

	@Override
	public void changeChannel(int num) {
		if(!power) return;
		channel = maxChannel<num?maxChannel:num;
		System.out.println("채널 : "+channel);
		
	}

	//클릭으로 하니까 에러안남;;
	public ExdTvReomoteCon(int maxChannel, int maxVolume) {
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
	}
	
	
}

class ExdLGTvRemoteController extends ExdTvReomoteCon{
	public final static String LOGO = "LG";
	public ExdLGTvRemoteController(int maxVolume, int maxChannel) {
		super(maxVolume, maxChannel);
	}
}

class ExdSamsungTvRemoteController extends ExdTvReomoteCon{
	public final static String LOGO = "SAMSUNG";
	public ExdSamsungTvRemoteController(int maxVolume, int maxChannel) {
		super(maxVolume, maxChannel);
	}
}