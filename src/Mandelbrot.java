
public class Mandelbrot {


	public static void main(String[] args) {
	int i;
		// TODO Auto-generated method stub
		MandelbrotGUI g = new MandelbrotGUI();
		i=0;
		Generator d = new Generator();
		while(true) {
			switch(g.getCommand()) {
			//Render 
			case 1<<0:
				d.render(g);
			i++;
			break;
			//zoom 
			case 1<<1:
				if(i!=0){
					d.render(g);
				}
				else {
					g.resetPlane();
				}
			break;
			//rest;
			case 1<<3:
				i=0;
				g.clearPlane();
				g.resetPlane();
			break;
			//Quit
			case 1<<4:
				System.exit(0);
			break;
			}
			//switch for res
			switch(g.getResolution()) {
			//RESOLUTION_VERY_LOWs
			case 1<<7:
			break;
			//RESOLUTION_LOW
			case 1<<8:
			break;
			//RESOLUTION_MEDIUM
			case 1<<9:
			break;
			//RESOLUTION_HIGH
			case 1<<10:
			break;
			//RESOLUTION_IS_VERY_HIGH
			case 1<<11:
			break; 
			} 
		}
	}

}
