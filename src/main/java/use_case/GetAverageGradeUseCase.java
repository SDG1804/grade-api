package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        int avg = 0;
        int members = 0;
        for (String utorid:gradeDB.getMyTeam().getMembers()) {
            avg += gradeDB.getGrade(utorid, course).getGrade();
            members++;
        }
        avg = avg/members;
        return avg;
    }
}
