package Principal;
import java.time.LocalDate;

public class Movimiento {
	private LocalDate Mov_Fecha;
	private String Mov_Nat;
	private double Mov_Cant;
	private String Mov_Descri;	
	
	public Movimiento(LocalDate mov_Fecha, String mov_Nat, double mov_Cant, String mov_Descri) {
		Mov_Fecha = mov_Fecha;
		Mov_Nat = mov_Nat;
		Mov_Cant = mov_Cant;
		Mov_Descri = mov_Descri;
	}
	public LocalDate getMov_Fecha() {
		return Mov_Fecha;
	}
	public void setMov_Fecha(LocalDate mov_Fecha) {
		Mov_Fecha = mov_Fecha;
	}
	public String getMov_Nat() {
		return Mov_Nat;
	}
	public void setMov_Nat(String mov_Nat) {
		Mov_Nat = mov_Nat;
	}
	public double getMov_Cant() {
		return Mov_Cant;
	}
	public void setMov_Cant(double mov_Cant) {
		Mov_Cant = mov_Cant;
	}
	public String getMov_Descri() {
		return Mov_Descri;
	}
	public void setMov_Descri(String mov_Descri) {
		Mov_Descri = mov_Descri;
	}
	
	public boolean comparaFecha(LocalDate fec) {
		return this.Mov_Fecha.equals(fec);
	}
	
}
