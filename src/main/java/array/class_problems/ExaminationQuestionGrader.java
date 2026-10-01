package array.class_problems;

import java.util.Scanner;

public class ExaminationQuestionGrader {

    static abstract class Question {

        String studentAnswer;
        double marks;

        Question(String studentAnswer, double marks) {
            this.studentAnswer = studentAnswer;
            this.marks = marks;
        }

        abstract double calculateScore();
    }

    static class ObjectiveQuestion extends Question {

        String correctAnswer;

        ObjectiveQuestion(String studentAnswer, String correctAnswer, double marks) {
            super(studentAnswer, marks);
            this.correctAnswer = correctAnswer;
        }

        @Override
        double calculateScore() {
            if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                return marks;
            }
            return 0;
        }
    }

    static class EssayQuestion extends Question {

        String correctAnswer;

        EssayQuestion(String studentAnswer, String correctAnswer, double marks) {
            super(studentAnswer, marks);
            this.correctAnswer = correctAnswer;
        }

        @Override
        double calculateScore() {

            String[] keywords = correctAnswer.split(",");
            int count = 0;

            String answer = studentAnswer.toLowerCase();

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    count++;
                }
            }

            if (count >= 2) {
                return marks * 0.75;
            } else if (count == 1) {
                return marks * 0.50;
            }

            return 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.nextLine();

            String[] parts = type.split("\\|");

            String questionType = parts[0];
            double marks = Double.parseDouble(parts[1]);
            String correctAnswer = parts[2];
            String studentAnswer = parts[3];

            Question question;

            if (questionType.equals("MCQ") || questionType.equals("TF")) {
                question = new ObjectiveQuestion(
                    studentAnswer,
                    correctAnswer,
                    marks
                );
            } else {
                question = new EssayQuestion(
                    studentAnswer,
                    correctAnswer,
                    marks
                );
            }

            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", questionType, score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}
