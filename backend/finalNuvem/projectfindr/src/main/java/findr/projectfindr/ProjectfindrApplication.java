package findr.projectfindr;

import findr.projectfindr.model.Contactor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProjectfindrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectfindrApplication.class, args);
    }
}