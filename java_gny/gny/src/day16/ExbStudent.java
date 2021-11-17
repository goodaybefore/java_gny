package day16;

public class ExbStudent {
		//private : 외부에서 멤버변수에 직접 접근하지 못하게 하기 위해서
		private String stdName;
		private int grade;
		private int stdClass;
		private int stdNum;
		private int kor;
		private int math;
		private int eng;
		
		//생성자는 멤버변수를 쉽게 초기화하기위해서 만든다.
		public ExbStudent(String stdName, int grade, int stdClass, int stdNum, int kor, int math, int eng) {
			this.stdName = stdName;
			this.grade = grade;
			this.stdClass = stdClass;
			this.stdNum = stdNum;
			this.kor = kor;
			this.math = math;
			this.eng = eng;
		}
		
		//toString 추가 : 멤버변수를 문자열로 쉽게 확인하기 위해서
		
		@Override
		public String toString() {
			return "["+stdName+"] "+grade+"학년 "+  stdClass+"반 "+ stdNum+"번 "+"["+" 국어 : "+kor+" 수학 : "+math+" 영어 : "+eng+"]";
		}

		public String getStdName() {
			return stdName;
		}

		public void setStdName(String stdName) {
			this.stdName = stdName;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		public int getStdClass() {
			return stdClass;
		}

		public void setStdClass(int stdClass) {
			this.stdClass = stdClass;
		}

		public int getStdNum() {
			return stdNum;
		}

		public void setStdNum(int stdNum) {
			this.stdNum = stdNum;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + grade;
			result = prime * result + stdClass;
			result = prime * result + stdNum;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ExbStudent other = (ExbStudent) obj;
			if (grade != other.grade)
				return false;
			if (stdClass != other.stdClass)
				return false;
			if (stdNum != other.stdNum)
				return false;
			return true;
		}
		
		//외부에서 멤버변수의 값을 확인하거나 수정하기 위해서


}
