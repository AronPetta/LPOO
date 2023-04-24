package veiculo;

public abstract class Vehicle implements Passengers, Load {
private String cor;
private String marca;
private String modelo;
private int qtdeRodas;
private double velocidade;
public Vehicle(String cor,String marca,String modelo,int qtdeRodas) {
this.cor=cor;
this.marca = marca;
this.modelo=modelo;
this.qtdeRodas=qtdeRodas;
}
public double getVelocidade() {
return velocidade;
}
public void setVelocidade(double velocidade) {
this.velocidade = velocidade;
}

public abstract void drive();

public String toString() {
return "Vehicle [cor =" + cor +", marca = " + marca +",modelo = "+modelo+",qtdeRodas = "+qtdeRodas+ "velocidade =" +velocidade+"]";
}
}

package veiculo;

public interface Motorized {
  void start();
}
package veiculo;

public interface Load {
float maxWeight();
}

package veiculo;

public interface Fuel extends Motorized{
  void abastecer();
  float capacidadeMaxima();
}
package veiculo;

public interface Passengers {
int numOfPassengers();
}

package veiculo;

public interface Eletric extends Motorized {
  void carregarBateria();
  float tempoDeBateria();
}
package veiculo;

public class Bike extends Vehicle{
private float weight;
private int numPassenger;

public Bike(float weight, int numPassenger, String cor,String marca,String modelo,int qtdeRodas){
super(cor, marca, modelo, qtdeRodas);
this.weight=weight;
this.numPassenger=numPassenger;
}
public int numOfPassengers() {
return numPassenger;
}
public float maxWeight(){
return weight;
}
public void drive(){
System.out.println("Guiar bicicleta "+super.getMarca()+" "+super.getModelo());
}
}

package veiculo;

public class EletricBike extends Bike implements Eletric {
  Scanner sc = new Scanner(System.in);
  
  public EletricBike(float weight, int numPassenger, String cor,String  marca,String modelo,int qtdeRodas){
    super(weight, numPassenger, cor, marca, modelo, qtdeRodas);
  }
  public void start(){
    System.out.println("Bicicleta em movimento");
  }
  public void carregarBateria(){
    System.out.println("Bateria sendo carregada");
  }
  public void tempoDeBateria(){
    System.out.println("Infirme o tempo de bateria");
    float tempo = sc.nextFloat();
    return tempo;
  }
}
package veiculo;
public class Teste {
public static void main(String[] args) {
Bike bike1=new Bike(100,1,"azul","Mountain Bike","Colli Bike",2);
bike1=drive();
EletricBike elBike1= new EletricBike(100,1,"Souza", "Eco 350w",2);
elBike1.carregarBateria();
elBike1.start();
elBike1.drive();
}
}

