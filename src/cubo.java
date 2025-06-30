import javax.swing.JOptionPane;
import java.util.Scanner;

public class cubo {
    //Código de ejemplo
    // Create a cube of integer numbers
    private int[][][] cube;
        // Main method to run the program
        public static void main(String[] args) {
            cubo ejecu = new cubo();
            ejecu.iniCubo(5);
            ejecu.impCubo();


        }

        private String[] empleados;
        private double[] costoHora;
        private int semanas;


        public void iniciar() {
            Scanner sc = new Scanner(System.in);
            int numEmpleados = 0;
            numEmpleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de empleados."));
            sc.nextLine();

            //guarda datos de empleados
            empleados = new String[numEmpleados];
            costoHora= new double[numEmpleados];

            //ingresa datos de empleado
            for (int i = 0; i < numEmpleados; i++) {
                empleados[i]= JOptionPane.showInputDialog("Ingrese el nombre del empleado " + (i + 1));

            }
            //ingresa horas trabajadas
            for (int i = 0; i < numEmpleados; i++) {
                costoHora[i]= Double.parseDouble(JOptionPane.showInputDialog("Ingrese las horas trabajadas de " + empleados[i] + ": "));

            }
            //registra semanas del mes
            semanas= Integer.parseInt(JOptionPane.showInputDialog("Indique las semanas que tiene el mes por registrar: "));
            //valida que se un numero de semana valido
            while (semanas < 4 || semanas > 5) {
                System.out.print("Cantidad de semanas invalida. Ingrese 4 o 5: ");
                semanas = Integer.parseInt(JOptionPane.showInputDialog("Indique las semas que tiene el mes por registrar: "));
            }


            iniCubo();
            impCubo();
            calculaPlanilla();
        }


        // Function to create a cube of integer numbers with the given size
        public void iniCubo(int size) {
            if (size <= 0) {
                System.out.println("Size must be a positive integer.");
                return;
            }
            cube = new int[empleados.length][6][semanas];

            // Fill the cube with random values
            for(int fil = 0; fil < empleados.length; fil++) {
                for(int col = 0; col < 6 ; col++) {
                    for(int alt = 0; alt < semanas; alt++) {
                        cube[fil][col][alt] = 8 + (int)(Math.random() * 5);
                    }
                }
            }
        }

        // Function to print the cube
        public void impCubo() {
            if (cube == null) {
                System.out.println("Cube is not initialized.");
                return;
            }

            for (int fil = 0; fil < empleados.length; fil++) {
                for (int col = 0; col < semanas; col++) {
                    for (int alt = 0; alt < 6; alt++) {
                        System.out.printf("%-4s", cube[fil][alt][col]);
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
           public void calculaPlanilla() {
                int[] horasNormales = new int[empleados.length];
                double[] salarioBruto = new double[empleados.length];

                for (int emp = 0; emp < empleados.length; emp++) {
                    for (int sem = 0; sem < semanas; sem++) {
                        for (int dia = 0; dia < 6; dia++) {
                            int horas = cube[emp][dia][sem];
                            if (horas <= 8) {
                                horasNormales[emp] += horas;
                            }
                        }
                    }
                    double normal = horasNormales[emp] * costoHora[emp];
                    salarioBruto[emp] = normal;
                }


            }
        }
        //




