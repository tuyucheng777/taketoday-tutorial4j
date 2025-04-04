package cn.tuyucheng.taketoday.picocli.git;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.tuyucheng.taketoday.picocli.git.commands.programmative.GitCommand;
import cn.tuyucheng.taketoday.picocli.git.commands.subcommands.GitAddCommand;
import cn.tuyucheng.taketoday.picocli.git.commands.subcommands.GitCommitCommand;
import cn.tuyucheng.taketoday.picocli.git.commands.subcommands.GitConfigCommand;

import picocli.CommandLine;

@SpringBootApplication
public class Application implements CommandLineRunner {
   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   private GitCommand gitCommand;
   private GitAddCommand addCommand;
   private GitCommitCommand commitCommand;
   private GitConfigCommand configCommand;

   @Autowired
   public Application(GitCommand gitCommand, GitAddCommand addCommand, GitCommitCommand commitCommand, GitConfigCommand configCommand) {
      this.gitCommand = gitCommand;
      this.addCommand = addCommand;
      this.commitCommand = commitCommand;
      this.configCommand = configCommand;
   }

   @Override
   public void run(String... args) {
      CommandLine commandLine = new CommandLine(gitCommand);
      commandLine.addSubcommand("add", addCommand);
      commandLine.addSubcommand("commit", commitCommand);
      commandLine.addSubcommand("config", configCommand);

      commandLine.parseWithHandler(new CommandLine.RunLast(), args);
   }
}