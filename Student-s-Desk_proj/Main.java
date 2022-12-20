import src.Database.Alamnac.Alamnac;
import src.Database.Courses.Courses;
import src.Database.LoadDatabase.LoadDatabase;
import src.Database.Marksheets.Marksheets;
import src.Database.StudentLoad.StudentLoad;
import src.Database.StudentLoad.TeacherLoad;
import src.Database.Timetable.Timetable;
import src.Example.Main2;
import src.administration.Project;
import src.administration.DeleteByID;

public class Main {
    public static void help(){
        System.out.println("-h : help");
        System.out.println("-load <name> : load csv file");
        System.out.println("-view <name> : view sql databases");
        System.out.println("-delStu <ID> : Delete student by ID");
        return;
    }

    public static void main(String[] args) {
        LoadDatabase db;
        if(args.length == 0){
            // System.out.println("Welcome to Students Desk");
            // System.out.println("Use the following commands :");
            // help();
            Project.main2();
            return;
        }else if(args.length == 1){
            if(args[0].compareTo("-h") == 0){
                help();
                return;
            }else if(args[0].compareTo("-load") == 0){
                System.out.println("More arguments required !!!");
            }
            else{
                System.out.println("INVALID COMMAND !!!");
            }
        }else if(args.length == 2) {
            if(args[0].compareTo("-load") == 0){
                String name = args[1];
                if(name.compareTo("timetable") == 0){
                    db = new Timetable();
                    db.loadCsv(name, "./files");
                    System.out.println(">>> Timetable loaded <<<");
                }else if(name.compareTo("courses") == 0){
                    db = new Courses();
                    db.loadCsv(name, "./files");
                    System.out.println(">>> Courses loaded <<<");
                }else if(name.compareTo("marksheets") == 0){
                    db = new Marksheets();
                    db.loadCsv(name, "./files");
                    System.out.println(">>> Marksheets loaded <<<");
                }else if(name.compareTo("student") == 0){
                    db = new StudentLoad();
                    db.loadCsv("stu_info", "./files");
                    System.out.println(">>> Students loaded <<<");
                }else if(name.compareTo("teacher") == 0){
                    db = new TeacherLoad();
                    db.loadCsv(name, "./files");
                    System.out.println(">>> Teacher loaded <<<");
                }
                else{
                    System.out.println("INVALID COMMAND !!!");
                }
            }else if(args[0].compareTo("-view") == 0){
                String name = args[1];
                if(name.compareTo("timetable") == 0){
                    Timetable db1 = new Timetable();
                    db1.viewDatabase(name);
                }else if(args[1].compareTo("courses") == 0){
                    Courses db1 = new Courses();
                    db1.viewDatabase(name);
                }else if(args[1].compareTo("marksheets") == 0){
                    Marksheets db1 = new Marksheets();
                    db1.viewDatabase(name);
                }else if(name.compareTo("alamnac") == 0){
                    System.out.println("More arguments required !!!");
                }else{
                    System.out.println("INVALID COMMAND !!!");
                }
            }else if(args[0].compareTo("-delStu") == 0){
                String ID = args[1];
                DeleteByID.deleteID(ID);
            }
            else{
                System.out.println("INVALID COMMAND");
            }
        }else if(args.length == 3){
            if(args[0].compareTo("-load") == 0){
                if(args[1].compareTo("alamnac") == 0){
                    String name = args[2];
                    db = new Alamnac();
                    db.loadCsv(name, "./files");
                    System.out.println(">>> Alamac loaded <<<");
                }else{
                    System.out.println("INVALID COMMAND !!!");
                }
            }else if(args[0].compareTo("-view") == 0){
                if(args[1].compareTo("alamnac") == 0){
                    String name = args[2];
                    Alamnac db1 = new Alamnac();
                    db1.viewDatabase(name);
                }
            }
            else{
                System.out.println("INVALID COMMAND");
            }
        }else{
            System.out.println("INVALID COMMAND");
        }
    }
}
