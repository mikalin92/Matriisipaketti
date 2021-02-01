package matriisipaketti;

public class Matriisi {
	private int rivit,sarakkeet;
	private double[][] matriisi;
	
	
	
	public Matriisi(int rivit, int sarakkeet) {
		this.rivit=rivit;
		this.sarakkeet=sarakkeet;
		matriisi=new double[rivit][sarakkeet];
		
	}
	
	
	public Matriisi inverssi() {
		Matriisi inverssi=new Matriisi(this.sarakkeet,this.rivit);
		inverssi=this.kofaktori().transpoosi();
		for(int i=0;i<this.rivit;i++) {
			for(int j=0;j<this.sarakkeet;j++) {
				inverssi.matriisi[i][j]/=this.determinantti();
			}
		}
		
		return inverssi;
	}
	
	
	
	public Matriisi kofaktori() {
		
		Matriisi kofaktori=new Matriisi(this.sarakkeet,this.rivit);
		Matriisi alimatriisi=new Matriisi(this.sarakkeet-1,this.rivit-1);
		
		
		for(int i=0;i<this.rivit;i++) {
			for(int j=0;j<this.sarakkeet;j++) {
				for(int k=0;k<alimatriisi.rivit;k++) {
					for(int l=0;l<alimatriisi.rivit;l++) {
						
						if(k<i&&l<j) {alimatriisi.matriisi[k][l]=this.matriisi[k][l];}
						else if(k<i&&l>=j) {alimatriisi.matriisi[k][l]=this.matriisi[k][l+1];}
						else if(k>=i&&l<j) {alimatriisi.matriisi[k][l]=this.matriisi[k+1][l];}
						else {alimatriisi.matriisi[k][l]=this.matriisi[k+1][l+1];}
						
						
						
					
					
					}
				}
				kofaktori.matriisi[i][j]=Math.pow(-1, i+j)*alimatriisi.determinantti();
			}
		}
		
		
		
		return kofaktori;
	}
	
	
	
	
	public double determinantti() {
		if(this.rivit==1) {return matriisi[0][0];}
		else {
			double det=0;
			Matriisi alimatriisi=new Matriisi(this.rivit-1,this.rivit-1);
			
			for(int i=0;i<this.rivit;i++) {
			
				for(int k=0;k<alimatriisi.rivit;k++) {
					for(int l=0;l<alimatriisi.rivit;l++) {
						if(l<i) {
							alimatriisi.matriisi[k][l]=this.matriisi[k+1][l];
						}
						else {
							alimatriisi.matriisi[k][l]=this.matriisi[k+1][l+1];
						}
						
						
						
					}
				}
				det+=Math.pow(-1, i)*this.matriisi[0][i]*alimatriisi.determinantti();
			}
			
			
			
			
			return det;
		}
		
		
		
		
	}
	
	
	
	
	
	
	public Matriisi kerroMatriisilla(Matriisi oikealla) {
		Matriisi kertoma =new Matriisi(this.rivit,oikealla.sarakkeet);
		for(int i=0;i<kertoma.rivit;i++) {
			for(int k=0; k<kertoma.sarakkeet; k++) {
				double summa=0;
				for(int j=0; j<this.sarakkeet; j++) {
					summa+=this.matriisi[i][j]*oikealla.matriisi[j][k];
				}
				kertoma.matriisi[i][k]=summa;
				
				
			}
		}
		
		
		
		
		return kertoma;
	}
	
	
	
	
	
	public void asetaArvo(int m,int n, double arvo) {
		
		this.matriisi[m][n]=arvo;
		
	}
	

	public Matriisi lisääMatriisilla(Matriisi lisäys) {
		Matriisi summa =new Matriisi(this.rivit,this.sarakkeet);
		for(int i=0;i<rivit;i++) {
			for(int j=0; j<sarakkeet; j++) {
				summa.matriisi[i][j]=this.matriisi[i][j]+lisäys.matriisi[i][j];
			}
		}
		
		return summa;
	}
	
	
	
	public Matriisi transpoosi() {
		Matriisi transpoosi=new Matriisi(this.sarakkeet,this.rivit);
		
		for(int i=0;i<rivit;i++) {
			for(int j=0; j<sarakkeet; j++) {
				transpoosi.matriisi[j][i]=this.matriisi[i][j];
			}
		}
		return transpoosi;
	}
	
	
	public void tulosta() {
		for(int i=0;i<rivit;i++) {
			for(int j=0; j<sarakkeet; j++) {
				System.out.print(this.matriisi[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
