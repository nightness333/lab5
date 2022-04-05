import Utilities.FileWorker;
import Utilities.Shell;

public class Main {

    public static void main(String[] args) {

        String mainFileName = "";

        for (int i = 0; i < args.length; i++) {
            mainFileName = mainFileName + args[i] + " ";
        }

        System.out.println(mainFileName);

        /*mainFileName = "C:\\Users\\Костя Черемнов\\Downloads\\lol.xml";*/

        FileWorker fileWorker = new FileWorker();

        boolean flag = false;

        try {
            fileWorker.fileWorker(mainFileName.trim());
            flag = true;
        } catch (Exception e) {
            System.out.println("$ Ошибка, преждевременное завершение программы");
        }

        if (flag) {
            Shell shell = new Shell();

            try {
                shell.shell();
            } catch (Exception e) {
                System.out.println("$ Ошибка, преждевременное завершение программы");
            }
        }

    }

}
