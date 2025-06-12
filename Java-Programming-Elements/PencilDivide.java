public class PencilDivide{
    public static void main(String[] args) {
        int totalPencils = 14; // Total number of pencils
        int students = 3; // Number of students
        int pencilsPerStudent = totalPencils / students; // Pencils each student gets
        int remainingPencils = totalPencils % students; // Remaining pencils after division
        System.out.println("The Pen Per Student is "+ pencilsPerStudent+" and the remaining pen not distributed is " + remainingPencils);
    }
}