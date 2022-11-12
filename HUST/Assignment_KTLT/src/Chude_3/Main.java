package Chude_3;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<MonHoc> dsMonHoc = new ArrayList<>(); 
	
	private static int nhapMotSo(int a, int b) {
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		while (choose < a || choose > b) {
			System.out.println("Nhập sai! hãy nhập 1 số từ " + a + " đến " + b);
			choose = scan.nextInt();
		}
		scan.nextLine();
		return choose;
	}

	public static void main(String[] args) {
		// mở file khi bắt đầu chương trình
		readFile();
		System.out.println("Hãy chọn 1 môn học: ");
		for (int i = 0; i < dsMonHoc.size(); i++) {
			System.out.println((i + 1) + ": " + dsMonHoc.get(i).getTenMonHoc());
		}
		int choose = nhapMotSo(1, dsMonHoc.size()) - 1;
		Job job = new Job(dsMonHoc.get(choose));
		job.menuChinh(dsMonHoc);
	}

	/**
	 * đọc arraylist từ file
	 */
	public static void readFile() {
		String fileName = "data.dat";
		try {
			FileInputStream f = new FileInputStream(fileName);
			ObjectInputStream inStream = new ObjectInputStream(f);
			ArrayList<MonHoc> readObject = (ArrayList<MonHoc>) inStream.readObject();
			dsMonHoc = readObject;
			inStream.close();
			f.close();
		} catch (IOException e) {
			System.out.println("lỗi đọc file" + fileName);
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			System.out.println("lỗi classnotfound " + fileName);
			e1.printStackTrace();
		}
	}
}

class Job {
	private MonHoc monHoc;
	private Scanner scan = new Scanner(System.in);

	public Job(MonHoc a) {
		monHoc = a;
	}

	/**
	 * ghi arraylist ra file
	 */
	public void writeFile(ArrayList<MonHoc> dsMonHoc) {
		String fileName = "data.dat";
		try {
			File file = new File(fileName);
			file.createNewFile();
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream oStream = new ObjectOutputStream(f);
			oStream.writeObject(dsMonHoc);
			oStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("lỗi ghi file");
		}
	}

	/**
	 * @param a
	 * @param b
	 * @return một số nguyên
	 * 
	 *         yêu cầu người dùng nhập 1 số trong khoảng a, b
	 */
	private int nhapMotSo(int a, int b) {
		int choose = scan.nextInt();
		while (choose < a || choose > b) {
			System.out.println("Nhập sai! hãy nhập 1 số từ " + a + " đến " + b);
			choose = scan.nextInt();
		}
		scan.nextLine();
		return choose;
	}

	/**
	 * @param dsMonHoc
	 * 
	 *            Menu chính của chương trình, gồm 3 chức năng lớn
	 */
	public void menuChinh(ArrayList<MonHoc> dsMonHoc) {
		System.out.println("Môn: " + monHoc.getTenMonHoc());
		while (true) {
			System.out.println("\nHãy lựa chọn: ");
			System.out.println("1: Tiếp tục làm việc với các đề đã có");
			System.out.println("2: Tạo mới đề thi từ ngân hàng câu hỏi");
			System.out.println("3: Xem, thêm, xóa, sửa các câu hỏi có sẵn");
			System.out.println("4: Lưu các đề thi, câu hỏi");
			System.out.println("5: Lưu và thoát");
			int temp = nhapMotSo(1, 5);
			if (temp == 1) {
				lamViecCacDeThiCoSan();
			} else if (temp == 2) {
				System.out.println("Bạn đã chọn tạo đề thi từ ngân hàng câu hỏi.");
				System.out.println("Hãy nhập tên đề thi:");
				taoDeThi(new DeThi(scan.nextLine()));
			} else if (temp == 3) {
				themXoaSuaCauHoi();
			} else if (temp == 4) {
				writeFile(dsMonHoc);
			} else if (temp == 5) {
				System.out.println("Cảm ơn đã sử dụng chương trình");
				writeFile(dsMonHoc);
				break;
			}
		}
	}

	/**
	 * xem, xóa, sửa lại các đề thi đã có sẵn
	 */
	public void lamViecCacDeThiCoSan() {
		System.out.println("Bạn đã chọn các đề thi có sẵn");
		while (true) {
			System.out.println("Hãy chọn:");
			System.out.println("1.Xem tất cả đề thi môn " + monHoc.getTenMonHoc());
			System.out.println("2.Xóa 1 đề thi");
			System.out.println("3.Sửa 1 đề thi");
			System.out.println("4.Trở về menu trước");
			int choose = nhapMotSo(1, 4);
			if (choose == 1) {
				System.out.println("Hiện tại có " + monHoc.dsDeThi.size() + " đề thi");
				for (int i = 0; i < monHoc.dsDeThi.size(); i++) {
					System.out.println(i + 1 + "." + monHoc.dsDeThi.get(i).getTenDeThi());
				}
			} else if (choose == 2) {
				System.out.println("Hãy nhập stt đề cần xóa");
				int index = nhapMotSo(1, monHoc.dsDeThi.size());
				monHoc.xoaDeThi(index - 1);
			} else if (choose == 3) {
				System.out.println("Hãy nhập stt đề cần sửa");
				int index = nhapMotSo(1, monHoc.dsDeThi.size());
				taoDeThi(monHoc.dsDeThi.get(index - 1));
			} else if (choose == 4) {
				break;
			}
		}
	}

	/**
	 * @param deThiCoSan
	 * 
	 *            tạo mới 1 đề thi 
	 */
	public void taoDeThi(DeThi deNhap) {
		ArrayList<CauHoi> cauHoiChuaChon = new ArrayList<>();
		for (CauHoi cauHoi : monHoc.dsCauHoi) {
			if (!deNhap.getDsCauHoi().contains(cauHoi))
				cauHoiChuaChon.add(cauHoi);
		}
		while (true) {
			System.out.println("\nHãy chọn: ");
			System.out.println("1.Xem các câu hỏi chưa được chọn vào đề");
			System.out.println("2.Xem đề thi bạn đang soạn");
			System.out.println("3.Xóa câu hỏi trong đề thi đang soạn");
			System.out.println("4.Thêm vào ngẫu nhiên 1 số câu hỏi TN cùng độ khó");
			System.out.println("5.Thêm vào ngẫu nhiên 1 số câu hỏi TL cùng độ khó");
			System.out.println("6.Thêm vào các câu hỏi theo ý muốn");
			System.out.println("7.Lưu lại đề ");
			System.out.println("8.Sửa tên đề thi");
			System.out.println("9.Trở về menu trước");
			int choose = nhapMotSo(1, 9);
			if (choose == 1) {
				System.out.println("Bạn đã chọn xem các câu hỏi có sẵn");
				for (int i = 0; i < cauHoiChuaChon.size(); i++) {
					System.out.print("Câu " + (i + 1) + " ");
					cauHoiChuaChon.get(i).in();
				}
			} else if (choose == 2) {
				deNhap.in();
			} else if (choose == 3) {
				System.out.println("Hãy nhập STT câu hỏi cần xóa: ");
				int index = nhapMotSo(1, deNhap.getDsCauHoi().size()) - 1;
				CauHoi cauHoiCanXoa = deNhap.getDsCauHoi().get(index);
				if (cauHoiCanXoa instanceof CauHoiTN)
					cauHoiChuaChon.add(0, cauHoiCanXoa);
				else
					cauHoiChuaChon.add(cauHoiCanXoa);
				deNhap.xoaCauHoi(index);
			} else if (choose == 4) {
				int doKhoMin, doKhoMax, soCauHoi;
				System.out.println("Hãy nhập độ khó tối thiểu: (trong khoảng 1 đến 5)");
				doKhoMin = nhapMotSo(1, 5);
				System.out.println("Hãy nhập độ khó tối đa: (từ " + doKhoMin + " đến 5");
				doKhoMax = nhapMotSo(doKhoMin, 5);
				System.out.println("Hãy nhập số câu muốn thêm: ");
				soCauHoi = nhapMotSo(1, Integer.MAX_VALUE);
				ArrayList<CauHoi> ungCuVien = new ArrayList<>();
				for (CauHoi cauHoi : cauHoiChuaChon) {
					if (cauHoi instanceof CauHoiTN && cauHoi.getDoKho() >= doKhoMin && cauHoi.getDoKho() <= doKhoMax)
						ungCuVien.add(cauHoi);
				}
				Random rand = new Random();
				for (int i = soCauHoi - 1; i >= 0 && ungCuVien.size() > 0; i--) {
					int index = rand.nextInt(ungCuVien.size());
					deNhap.themCauHoi(ungCuVien.get(index));
					cauHoiChuaChon.remove(ungCuVien.get(index));
					ungCuVien.remove(index);
				}
			} else if (choose == 5) {
				int doKhoMin, doKhoMax, soCauHoi;
				System.out.println("Hãy nhập độ khó tối thiểu: (trong khoảng 1 đến 5)");
				doKhoMin = nhapMotSo(1, 5);
				System.out.println("Hãy nhập độ khó tối đa: (từ " + doKhoMin + " đến 5");
				doKhoMax = nhapMotSo(doKhoMin, 5);
				System.out.println("Hãy nhập số câu muốn thêm: ");
				soCauHoi = nhapMotSo(1, Integer.MAX_VALUE);
				ArrayList<CauHoi> ungCuVien = new ArrayList<>();
				for (CauHoi cauHoi : cauHoiChuaChon) {
					if (cauHoi instanceof CauHoiTL && cauHoi.getDoKho() >= doKhoMin && cauHoi.getDoKho() <= doKhoMax)
						ungCuVien.add(cauHoi);
				}
				Random rand = new Random();
				for (int i = soCauHoi - 1; i >= 0 && ungCuVien.size() > 0; i--) {
					int index = rand.nextInt(ungCuVien.size());
					deNhap.themCauHoi(ungCuVien.get(index));
					cauHoiChuaChon.remove(ungCuVien.get(index));
					ungCuVien.remove(index);
				}
			} else if (choose == 6) {
				System.out.println("Hãy nhập stt  các câu hỏi muốn thêm: (cách nhau bởi dấu cách)");
				ArrayList<CauHoi> cauHoiMuonThem = new ArrayList<>();
				String lines = scan.nextLine();
				String[] strs = lines.trim().split("\\s+");
				for (int i = 0; i < strs.length; i++) {
					int index = Integer.parseInt(strs[i]) - 1;
					cauHoiMuonThem.add(cauHoiChuaChon.get(index));
				}
				for (CauHoi cauHoi : cauHoiMuonThem) {
					deNhap.themCauHoi(cauHoi);
					cauHoiChuaChon.remove(cauHoi);
				}
			} else if (choose == 7) {
				System.out.println("Đề thi đã được thêm, bạn cần lưu ra file để có thể sử dụng lần sau");
				if (!monHoc.dsDeThi.contains(deNhap))
					monHoc.themDeThi(deNhap);
			} else if (choose == 8) {
				System.out.println("Hãy nhập tên đề thi mới");
				deNhap.setTenDeThi(scan.nextLine());
			} else if (choose == 9) {
				break;
			}
		}
	}

	public void themXoaSuaCauHoi() {
		while (true) {
			System.out.println("\nHãy chọn: ");
			System.out.println("1.Xem các câu hỏi");
			System.out.println("2.Thêm 1 câu hỏi");
			System.out.println("3.Xóa 1 câu hỏi");
			System.out.println("4.Sửa 1 câu hỏi");
			System.out.println("5.Về menu trước");
			int choose = nhapMotSo(1, 5);
			if (choose == 1) {
				xemCauHoi();
			} else if (choose == 2) {
				themCauHoi();
			} else if (choose == 3) {
				xoaCauHoi();
			} else if (choose == 4) {
				// tự làm
			} else {
				break;
			}
		}
	}

	public void xemCauHoi() {
		System.out.println("Bạn đã chọn xem các câu hỏi có sẵn");
		for (int i = 0; i < monHoc.dsCauHoi.size(); i++) {
			System.out.print("Câu " + (i + 1) + " ");
			monHoc.dsCauHoi.get(i).in();
		}
	}

	public void xoaCauHoi() {
		System.out.println("Hãy nhập số thứ tự câu hỏi muốn xóa:  ");
		monHoc.xoaCauHoi(nhapMotSo(1, monHoc.dsCauHoi.size()) - 1);
	}

	public boolean themCauHoi() {
		System.out.println("Bạn đã chọn thêm câu hỏi vào ngân hàng");

		System.out.println("Loại câu hỏi muốn thêm? \n1: Trắc nghiệm    \n2: Tự luận   ");
		int flag = nhapMotSo(1, 2);
		if (flag == 1) {
			CauHoiTN cauHoi = new CauHoiTN();
			System.out.println("Độ khó: (1 đến 5)");
			cauHoi.setDoKho(nhapMotSo(1, 5));
			System.out.println("Hãy nhập câu hỏi: ");
			cauHoi.setNoiDungCauHoi(scan.nextLine());
			System.out.println("Nhập số đáp án: ");
			int soDA = nhapMotSo(2, Integer.MAX_VALUE);
			for (int i = 0; i < soDA; i++) {
				DapAnTN da = new DapAnTN();
				System.out.println("Nhập đáp án " + (char) ('A' + i) + ":   ");
				da.setTenDapAn((char) ('A' + i));
				da.setNoiDungDapAn(scan.nextLine());
				System.out.println("Đáp án đúng:    1:Đúng     2:Sai");
				if (nhapMotSo(1, 2) == 1) {
					da.setDapAnDung(true);
				} else
					da.setDapAnDung(false);
				cauHoi.themDapAn(da);
			}
			monHoc.themCauHoi(cauHoi);
		} else {
			CauHoiTL cauHoi = new CauHoiTL();
			System.out.println("Độ khó: (1 đến 5)");
			cauHoi.setDoKho(nhapMotSo(1, 5));
			System.out.println("Hãy nhập câu hỏi: ");
			cauHoi.setNoiDungCauHoi(scan.nextLine());
			System.out.println("Nhập đáp án: ");
			cauHoi.setDapAnTL(scan.nextLine());
			monHoc.themCauHoi(cauHoi);
		}
		return true;
	}
}
