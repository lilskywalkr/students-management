export function useGrade() {
    // Function for adding a grade
    async function addGrade(gradeData) {
        try {
            const res = await fetch("http://localhost:8080/api/grades/add", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(gradeData),
            });

            if (res.ok) {
                return {message: "Grade added successfully!", flag: true};
            } else {
                return {message: "Failed to add grade", flag: false}
            }
        } catch (err) {
            console.error("An error occurred: " + err.messages);
        }
    }

    // Function for deleting all grades when deleting a subject
    async function deleteGradeBySubjectId(subjectId) {
        try {
            const res = await fetch(`http://localhost:8080/api/grades/${subjectId}`, {
                method: "DELETE",
            });

            if (res.ok) {
                return {message: "Grade deleted successfully!", flag: true};
            } else {
                return {message: "Failed to delete grade", flag: false};
            }
        } catch (err) {
            console.error("An error occurred: " + err.message);
        }
    }

    // Function for deleting all grades when deleting a student
    async function deleteGradeByStudentId(studentId) {
        try {
            const res = await fetch(`http://localhost:8080/api/grades/std/${studentId}`, {
                method: "DELETE",
            });

            if (res.ok) {
                return {message: "Grades deleted successfully!", flag: true};
            } else {
                return {message: "Failed to delete grades", flag: false};
            }
        } catch (err) {
            console.error("An error occurred: " + err.message);
        }
    }

    // Function for updating a grade by its ID
    async function updateGradeByGradeId(id, grade) {
        try {
            const res = await fetch(`http://localhost:8080/api/grades/grade-update/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(grade),
            });

            if (res.status === 204) {
                return { message: "Grade updated successfully!", flag: true };
            } else {
                return { message: "Failed to update grade", flag: false }
            }
        } catch (err) {
            console.error("An error occurred: " + err.message);
        }
    }

    return {
        addGrade,
        deleteGradeBySubjectId,
        deleteGradeByStudentId,
        updateGradeByGradeId
    }
}