package cn.tuyucheng.taketoday.patterns.front.controller.commands;

import jakarta.servlet.ServletException;

import java.io.IOException;

public class UnknownCommand extends FrontCommand {
   @Override
   public void process() throws ServletException, IOException {
      forward("unknown");
   }
}