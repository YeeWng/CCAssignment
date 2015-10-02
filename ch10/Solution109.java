package ch10;

public class Solution109 {

	Coordinate findElement(int[][] mat, Coordinate ori, Coordinate dest, int x) {
		if (!ori.isInbounds(mat) || !dest.isInbounds(mat))
			return null;
		
		if (mat[ori.r][ori.c] == x) 
			return ori;
		else if (!ori.isBefore(dest))
			return null;
		
		Coordinate st = (Coordinate)ori.clone();
		int diagDist = Math.min(dest.r - ori.r, dest.c - ori.c);
		Coordinate ed = new Coordinate(st.r + diagDist, st.c + diagDist);
		Coordinate p = new Coordinate(0, 0);
		
		while (st.isBefore(ed)) {
			p.setToAverage(st, ed);
			if (x > mat[p.r][p.c]) {
				st.r = p.r + 1;
				st.c = p.c + 1;
			} else {
				ed.r = p.r - 1;
				ed.c = p.c - 1;
			}
		}
		
		return binarySerach(mat, ori, dest, st, x);
	}
	
	Coordinate binarySerach(int[][] mat, Coordinate ori, Coordinate dest, Coordinate pivot, int x) {
		Coordinate lowerLeftOri = new Coordinate(pivot.r, ori.c);
		Coordinate lowerLeftDest = new Coordinate(dest.r, pivot.c - 1);
		Coordinate upperRightOri = new Coordinate(ori.r, pivot.c);
		Coordinate upperRightDest = new Coordinate(pivot.r - 1, dest.c);
		
		Coordinate lowerLeft = findElement(mat, lowerLeftOri, lowerLeftDest, x);
		if (lowerLeft == null)
			return findElement(mat, upperRightOri, upperRightDest, x);
		
		return lowerLeft;
	}
	
	
	public static void main(String[] args) {
		/**
		 * 
		 */
		Solution109 s = new Solution109();
		int[][] mat = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};
		Coordinate ori = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(3, 3);
		// find 55 [Correct is r = 2, c = 1]
		Coordinate ret = s.findElement(mat, ori, dest, 55);
		System.out.println("r = " + ret.r + ", c = " + ret.c);
		// find 85 [Correct is r = 0, c = 3]
		ret = s.findElement(mat, ori, dest, 85);
		System.out.println("r = " + ret.r + ", c = " + ret.c);
		// find 5 [Correct is not found]
		ret = s.findElement(mat, ori, dest, 5);
		if (ret != null)
			System.out.println("r = " + ret.r + ", c = " + ret.c);
		else
			System.out.println("Not found.");
	}

}

class Coordinate implements Cloneable {
	public int r, c;
	public Coordinate(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public boolean isInbounds(int[][] mat) {
		return r >= 0 && c >= 0 &&
				r < mat.length && c < mat[0].length;
	}
	
	public boolean isBefore(Coordinate p) {
		return r <= p.r && c <= p.c;
	}
	
	public void setToAverage(Coordinate min, Coordinate max) {
		r = (min.r + max.r) / 2;
		c = (min.c + max.c) / 2;
	}
	
	public Object clone() {
		return new Coordinate(r, c);
	}
}
