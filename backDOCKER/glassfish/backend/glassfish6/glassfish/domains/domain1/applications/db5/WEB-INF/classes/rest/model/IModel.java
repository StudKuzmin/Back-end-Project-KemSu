package rest.model;

import rest.Student;
import java.util.List;

public interface IModel  {
  void run(List<Student> students) throws Exception;
}