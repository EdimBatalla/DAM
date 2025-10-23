public class procesos {

    public static void main(String[] args) {
        try{
            System.out.println("Obrint el bloc de notes...");
            new ProcessBuilder("explorer").start();
            System.out.println("Procés iniciat!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}