package pl.java.scalatech.functional;

@FunctionalInterface
interface StringToIntMapper {
  int map(String str);
}