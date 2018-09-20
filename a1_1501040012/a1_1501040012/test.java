package a1_1501040012;

public class test {
	public static void main(String[] args) {
		Hostel cos = new Hostel(1, "Anne", "Phung Khoang street", 13, 1F);
		Hostel cos1 = new Hotel(2, "Anne","Phung Khoang street", 15, 1F, 3F);
		System.out.println(cos.compareTo(cos1));
		System.out.println(cos);

	}
}
