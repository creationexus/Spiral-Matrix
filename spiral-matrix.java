package Array;

public class Dragon {
	int m[][];
	int w,h;
	int p;
	int c=0;
	int n=0;
	public Dragon(int n){
		this.n=n;
		this.w=this.h=this.calculoC(n);
		this.m = new int[this.h][this.w];
		this.c=this.calculo(n);
		this.p=0;
	}
	
	private boolean esMuro(int i, int j){
		if(i>=0&&j>=0&&i<this.h&&j<this.w)
			return false;
		return true;
	}
	
	public void volar(){
		this.volar(this.c, this.c, 1, 0, 0);
	}
	
	private void volar(int i, int j, int c, int it, int d){
		if(!esMuro(i,j)&&this.p<this.n){//hasta posicion valida o el p sea menor al n
			this.p++;
			this.m[i][j]=this.p;
			this.mostrarRecorrido();
			if(c==1){
				if(it<d){//itera hacia la derecha hasta el diametro maximo y se mantiene en el mismo ciclo
					this.volar(i, j+1, 1, it+1, d);//derecha					
				}else{
					this.volar(i, j+1, 2, 0, d);//derecha
				}
			}else if(c==2){
				if(it<d){//itera hacia abajo hasta el diametro maximo y se mantiene en el mismo ciclo
					this.volar(i+1, j, 2, it+1, d);//abajo
				}else{
					this.volar(i+1, j, 3, 0, d+1);//abajo
				}
			}else if(c==3){
				if(it<d){//itera hacia la izquierda hasta el diametro maximo y se mantiene en el mismo ciclo
					this.volar(i, j-1, 3, it+1, d);//izquierda
				}else{
					this.volar(i, j-1, 4, 0, d);//izquierda
				}
			}else if(c==4){
				if(it<d){//itera hacia la derecha hasta el diametro maximo y se mantiene en el mismo ciclo
					this.volar(i-1, j, 4, it+1, d);//arriba
				}else{
					this.volar(i-1, j, 1, 0, d+1);//arriba
				}
			}
		}
	}
	
	private void mostrarRecorrido(){
		for(int i=0;i<this.h;i++){
			for(int j=0;j<this.w;j++){
				System.out.format("%3s",this.m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private int calculoC(int n) {
	        //El tamaño inicial del cuadrado tiene que ser capaz de soportar el n inicial.
	        //Por ejemplo 5, de cuanto tendria que ser el cuadrado?
	        //Raiz cuadrada de (5) = 2.23... redondeo al alza y digo el cuadrado debe ser de 3x3
	        //Ahora si me ingresan el 17, de cuanto tendria que ser la matriz, sí con 4x4 soporto solo 16?
	        //4.1.... redondeo y digo 5x5, en conclusion sera asi:
	        return (int) Math.ceil(Math.sqrt(n));
	}
	
	private int calculo(int n) {
	        //En cada impar a partir del 3, se increnta 1
	        return (int) (Math.round((Math.ceil(Math.sqrt(n)))/2)-1);
	}
	
	public static void main(String args[]){
		Dragon dragon = new Dragon(81);//Al constructor se le pasan los movimientos
		dragon.volar();
	}
} 
