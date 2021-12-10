import java.awt.Color;
public class Generator {
	private int n=200;
	public Generator() {

	}

	/** Ritar en bild i fönstret i användargränssnittet gui */
	public void render(MandelbrotGUI gui) {
		gui.disableInput();
		
		Complex[][] complex = mesh(gui.getMinimumReal(),gui.getMaximumReal(),gui.getMinimumImag(),gui.getMaximumImag(),gui.getWidth(),gui.getHeight());
		Color[][] picture = new Color[gui.getHeight()][gui.getWidth()];
		Complex z;
		Complex c;
		for(int i = 0; i<gui.getHeight(); i++) {
			for(int j = 0; j<gui.getWidth();j++) {

				int k =0;
				z = new Complex(0,0);
				c= complex[i][j];
				while(k<n && z.getAbs2()<=4) {
					z.mul(z);
					z.add(c);
					k++;
				}
				switch(gui.getMode()) {
				//black and white
				case 1 << 5:
					if(k==n) {
						picture[i][j]= Color.black;
					}else if(k<n) {
						picture[i][j]= Color.white;
						} 

					break;
				//color
				case 1 << 6:
					if (k==200)
                    {
                        picture[i][j]=Color.black;
                    }
                    else if(k<10)
                    {picture[i][j]=Color.pink;}
                    else if(k<50)
                    {picture[i][j]=Color.red;}
                    else if(k<100)
                    {picture[i][j]=Color.blue;}
                    else if(k<150)
                    {picture[i][j]=Color.white;}
					break;
				}
				

				//				if(compelx[i][j].getAbs2()<1) {
				//					if(compelx[i][j].getRe()>0 && compelx[i][j].getIm()<0)
				//					picture[i][j]=Color.red;
				//					else if(compelx[i][j].getRe()>0 && compelx[i][j].getIm()>0)
				//					picture[i][j]=Color.yellow;
				//					else if(compelx[i][j].getRe()<0 && compelx[i][j].getIm()>0)
				//					picture[i][j]=Color.pink;
				//					else {
				//						picture[i][j]=Color.blue;
				//					}
				//				}else
				//					picture[i][j]=Color.white;

			}
		}
		gui.putData(picture, 1, 1);
		gui.enableInput();
	}
	
	/** Skapar en matris där varje element är ett komplext tal som
	har rätt koordinater (se beskrivning nedan) */
	
	private Complex[][] mesh(double minRe, double maxRe, double minIm, double maxIm,int width, int height){
		Complex c[][] = new Complex[height][width];
		double stepRe = (maxRe-minRe)/(width-1);
		double stepIm = (maxIm-minIm)/(height-1);
		for(int i = 0 ; i<height; i++) {
			for(int j = 0; j<width;j++) {
	 			c[i][j]= new Complex(minRe+(j*stepRe),maxIm-(i*stepIm));
				//System.out.println(c[i][j].getAbs2());
			}
		}
		return c;
	}
}
