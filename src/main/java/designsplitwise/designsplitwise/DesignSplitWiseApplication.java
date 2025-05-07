package designsplitwise.designsplitwise;

import designsplitwise.designsplitwise.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DesignSplitWiseApplication {
   private static Scanner scanner = new Scanner(System.in);

   @Autowired
   private CommandExecutor commandExecutor;
   public void run(String... args) throws Exception {
       String input = scanner.nextLine();
//       commandExecutor.execute(input);
   }
    public static void main(String[] args) {
        SpringApplication.run(DesignSplitWiseApplication.class, args);
    }

}
