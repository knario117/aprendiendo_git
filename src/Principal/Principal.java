package Principal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;

import Datos.Conexion;

public class Principal {
	
	public static void main(String[] args) {	
		int id = 5656, mes = 4, year= 2021;
		double saldoProm = saldoPromedio(id, mes, year);
		System.out.println("Saldo promedio: "+ String.valueOf(saldoProm));
	}
	
	public static double saldoPromedio(int idCliente, int mes, int year) {
		//Obtenemos los dias del mes e inicializamos el saldo en cero
		double saldo = 0;
		//double[] saldo = {0};
		YearMonth ym = YearMonth.of(year, mes);
		int dias = ym.lengthOfMonth();	
		//Lista para los saldos diarios
		ArrayList<Double> saldos = new ArrayList<Double>();
		//Metodo ficticio que nos retorna la lista de todos los movimientos del cliente en la fecha indicada
		ArrayList<Movimiento> movimientos = ObtenMovimientos(idCliente,mes,year);
		//Revisamos por dia los movimientos
		for(int dia = 1; dia <= dias; dia++) {
			LocalDate diaDelMes = LocalDate.of(year, mes, dia);
			for(Movimiento mov: movimientos) {
				if(mov.comparaFecha(diaDelMes)) {
					if(mov.getMov_Nat() == "Abono")
						saldo += mov.getMov_Cant();
					if(mov.getMov_Nat() == "Cargo") 
						saldo -= mov.getMov_Cant();
				}
			}
			/*movimientos.forEach(mov -> {
				//Si encontramos un movimiento de la fecha en la que vamos procedemos a realizar la operacion
				if(mov.comparaFecha(diaDelMes)) {
					if(mov.getMov_Nat() == "Abono")
						saldo[0] += mov.getMov_Cant();
					if(mov.getMov_Nat() == "Cargo") 
						saldo[0] -= mov.getMov_Cant();
				}
			});*/
			//Guardamos el saldo del dia de hoy
			saldos.add(saldo);
			//saldos.add(saldo[0]);
		}
		//Si tenemos saldos procedemos a calcular el saldo diario
		if(saldos.size() > 0)
		{
			double saldoTotal = 0;
			for(double diario: saldos) {
				saldoTotal += diario;
			}
			//double[] saldoTotal = {0};
			/*saldos.forEach(diario -> {
				saldoTotal[0] += diario;
			});*/			
			double saldoDiario = saldoTotal/dias;
			//double saldoDiario = saldoTotal[0]/dias;
			//redondear a 2 decimales y regresar el resultado
			BigDecimal bd = new BigDecimal(saldoDiario).setScale(2, RoundingMode.HALF_UP);			
			return bd.doubleValue();
		}
		else
		{
			return 0;
		}
	}

	public static ArrayList<Movimiento> ObtenMovimientos(int idCliente, int mes, int year) {
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		lista.add(new Movimiento(LocalDate.of(year,mes,1),"Abono",100.d, "Primer abono"));
		lista.add(new Movimiento(LocalDate.of(year,mes,4),"Abono",150.d, "Primer abono"));
		lista.add(new Movimiento(LocalDate.of(year,mes,4),"Cargo",50.d, "Primer abono"));
		lista.add(new Movimiento(LocalDate.of(year,mes,7),"Abono",100.d, "Primer abono"));
		lista.add(new Movimiento(LocalDate.of(year,mes,7),"Cargo",100.d, "Primer abono"));
		lista.add(new Movimiento(LocalDate.of(year,mes,13),"Abono",100.d, "Primer abono"));
		return lista;
	}
}
