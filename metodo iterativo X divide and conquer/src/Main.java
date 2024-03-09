import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        //fazendo testes para diferentes tamanhos de n com a mesma base, usando os dois métodos.
        //x=2

        // n =1
        BigInteger x = new BigInteger("2");
        long ini_it=System.nanoTime();
        BigInteger k = potencia_iterativo(1,x);
        //System.out.println(k);
        long fim_it=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=1 no método iterativo: %d\n",fim_it-ini_it);

        long ini_dc=System.nanoTime();
        k = potencia_divide_conquer(1,x);
        //System.out.println(k);
        long fim_dc=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=1 no método divide and conquer: %d\n",fim_dc-ini_dc);

        // n =10

        ini_it=System.nanoTime();
        k = potencia_iterativo(10,x);
        //System.out.println(k);
        fim_it=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=10 no método iterativo: %d\n",fim_it-ini_it);

        ini_dc=System.nanoTime();
        k = potencia_divide_conquer(10,x);
        //System.out.println(k);
        fim_dc=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=10 no método divide and conquer: %d\n",fim_dc-ini_dc);

        // n =100

        ini_it=System.nanoTime();
        k = potencia_iterativo(100,x);
        //System.out.println(k);
        fim_it=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=100 no método iterativo: %d\n",fim_it-ini_it);

        ini_dc=System.nanoTime();
        k = potencia_divide_conquer(100,x);
        //System.out.println(k);
        fim_dc=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=100 no método divide and conquer: %d\n",fim_dc-ini_dc);

        //n médio= 1000

        ini_it=System.nanoTime();
        potencia_iterativo(1000,x);
        fim_it=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=1000 no método iterativo: %d\n",fim_it-ini_it);

        ini_dc=System.nanoTime();
        potencia_divide_conquer(1000,x);
        fim_dc=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=1000 no método divide and conquer: %d\n",fim_dc-ini_dc);

        //n grande= 10000

        ini_it=System.nanoTime();
        potencia_iterativo(10000,x);
        fim_it=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=10000 no método iterativo: %d\n",fim_it-ini_it);

        ini_dc=System.nanoTime();
        potencia_divide_conquer(10000,x);
        fim_dc=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=10000 no método divide and conquer: %d\n",fim_dc-ini_dc);


        // n = 100000
        ini_it=System.nanoTime();
        potencia_iterativo(100000,x);
        fim_it=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=100000 no método iterativo: %d\n",fim_it-ini_it);

        ini_dc=System.nanoTime();
        potencia_divide_conquer(100000,x);
        fim_dc=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=100000 no método divide and conquer: %d\n",fim_dc-ini_dc);

        // n = 1000000
        ini_it=System.nanoTime();
        potencia_iterativo(1000000,x);
        fim_it=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=1000000 no método iterativo: %d\n",fim_it-ini_it);

        ini_dc=System.nanoTime();
        potencia_divide_conquer(1000000,x);
        fim_dc=System.nanoTime();
        System.out.printf("Tempo de execução em nanosegundos para n=1000000 no método divide and conquer: %d\n",fim_dc-ini_dc);
    }

    //nesse caso, vamos considerar n como o expoente e x a base, ou seja temos x^n
    public static BigInteger potencia_iterativo(int n, BigInteger x){
        BigInteger resultado = new BigInteger("1");
        for (int i =0;i<n;i++) {
            resultado = resultado.multiply(x);
        }
        return resultado;
    }

    //nesse caso, utilizamos a técnica de divide and conquer, a partir da recursão, dividindo o problema em subproblemas menores,
    //ou seja, vamos dividindo o expoente pela metade até ele ser igual a zero, afim de facilitar os cálculos, visto q dessa forma, podemos reduzir o número de multiplicações necessárias.
    public static BigInteger potencia_divide_conquer(int n, BigInteger x){
        if(n==0){
            return new BigInteger("1");
        }
        if(n==1){
            return x;
        }
       BigInteger r= (potencia_divide_conquer(n/2,x));
        if(n%2==0){
            return r.multiply(r);
        }
        else{
            return (r.multiply(r)).multiply(x);
        }
    }

}