package btap_5;

import javax.swing.*;   
import java.awt.*;
import java.util.LinkedList;
import java.util.*;

public class maze {
	public static void main(String[] args) {
		//
		JFrame frame = new JFrame();
		frame.setSize(650, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);
		frame.setVisible(true);
	}

	public static class MazePanel extends JPanel {
		private static final long serialVersionUID = -566807999447681130L;
		private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		private int sizeh, sizew, start, end;

		public MazePanel() {
			// Kích thước ma trận
			sizeh = 21;
			sizew = 31;
			start = 10;
			end = 0;
			repaint(); // vẽ ma trận và lời giải
		}

		/**
		 * Implement một phương pháp tìm đường nào đó.
		 * <p>
		 * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
		 * các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
		 * tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
		 * <p>
		 * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
		 * xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
		 */
		public void solve() {
			int i = start;
			int j = end + 1;
			
			maze[i][j-1] = 3;
			
			Queue<Point> list = new LinkedList<Point>();
			
			while(maze[i][j] != 2) {
				
				Point point = new Point(i,j);
				
				if (maze[i][j] == 0) {
					
					list.add(point);
					maze[i][j] = 3;
					if (maze[i-1][j] == 0) {
						i = i - 1;
					} else if (maze[i][j-1] == 0) {
						j = j - 1;
					} else if (maze[i+1][j] == 0) {
						i = i + 1;
					} else if (maze[i][j+1] == 0) {
						j = j + 1;
					} else if (maze[i-1][j] == 2) {
						i = i - 1;
					} else if (maze[i][j-1] == 2) {
						j = j - 1;
					} else if (maze[i+1][j] == 2) {
						i = i + 1;
					} else if (maze[i][j+1] == 2) {
						j = j + 1;
					} else if (maze[i-1][j] == 3) {
						i = i - 1;
					} else if (maze[i][j-1] == 3) {
						j = j - 1;
					} else if (maze[i+1][j] == 3) {
						i = i + 1;
					} else if (maze[i][j+1] == 3) {
						j = j + 1;
					}
				}
				
				if (maze[i][j] == 3) {
					
					maze[i][j] = 4;
					
					if (maze[i-1][j] == 0) {
						i = i - 1;
					} else if (maze[i][j-1] == 0) {
						j = j - 1;
					} else if (maze[i+1][j] == 0) {
						i = i + 1;
					} else if (maze[i][j+1] == 0) {
						j = j + 1;
					} else if (maze[i-1][j] == 3) {
						i = i - 1;
					} else if (maze[i][j-1] == 3) {
						j = j - 1;
					} else if (maze[i+1][j] == 3) {
						i = i + 1;
					} else if (maze[i][j+1] == 3) {
						j = j + 1;
					}
				}
			}
		}

		public void paintComponent(Graphics g) // vẽ ma trận + lời giải
		{
			super.paintComponent(g);
			for (int j = 0; j < sizew; j++)
				for (int i = 0; i < sizeh; i++) {
					if (i == start && j == end)
						g.setColor(Color.yellow);
					else if (maze[i][j] == 0 || maze[i][j] == 4)
						g.setColor(Color.white);
					else if (maze[i][j] == 1)
						g.setColor(Color.black);
					else if (maze[i][j] == 2)
						g.setColor(Color.red);
					else if (maze[i][j] == 3)
						g.setColor(Color.blue); // blue là màu của lời giải
					g.fillRect(j * 20, i * 20, 20, 20);
				}
		}
	}
}
