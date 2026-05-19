// 画像のフィルタ処理の基礎
import java.text.*;
public class FImageTest{
    public static void main(String args[]){
	int a[][]=new int[][]{{0, 0,   0,   0,   0,   0,   0, 0, 0},// 原画像
			      {0, 0,  80,  90, 100, 100, 110, 0, 0},
			      {0, 0, 100,  70, 100,  80, 100, 0, 0},
			      {0, 0, 100, 110, 100,  90, 100, 0, 0},
			      {0, 0,  90, 100, 100, 100, 120, 0, 0},
			      {0, 0, 100, 120,  90, 100, 100, 0, 0},
			      {0, 0, 100, 130, 100, 100, 110, 0, 0},
			      {0, 0,   0,   0,   0,   0,   0, 0, 0}};
				      
	double filter[][]=new double[][]{{1/9., 1/9., 1/9.},// 平滑化フィルタ
					 {1/9., 1/9., 1/9.},
					 {1/9., 1/9., 1/9.}};
		
	int fimage[][]=new int[a.length][a[0].length]; // 処理後画像
	int i,j;
		
	DecimalFormat f=new DecimalFormat();// 画面出力の書式設定をする
		
	f.applyPattern("000"); // 整数３桁で表示
		
	Image image=new Image(a); // Imageオブジェクトの生成
	image.filteredimage(fimage, filter); // フィルタ処理
		
	for(i=0;i<a.length;i++){
	    for(j=0;j<a[0].length;j++){
		System.out.print(f.format(fimage[i][j])+" ");
	    }
	    System.out.println();
	}
    }
}

class Image{
    int	a[][]=new int[9][9];
    Image(int x[][]){
	a=x;
    }
	
    void filteredimage(int b[][], double c[][]){
	int i,j;
	for(i=1;i<a.length-1;i++){
	    for(j=1;j<a[0].length-1;j++){
		b[i][j]=(int)( a[i-1][j-1]*c[0][0]+a[i-1][j]*c[0][1]+a[i-1][j+1]*c[0][2]
			       +a[i][j-1]*c[1][0]  +a[i][j]*c[1][1]  +a[i][j+1]*c[1][2]
			       +a[i+1][j-1]*c[2][0]+a[i+1][j]*c[2][1]+a[i+1][j+1]*c[2][2]);
	    }
	}
    }
}
