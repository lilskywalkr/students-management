export function useStudent() {

    // Function to add a student
    async function addStudent(studentData) {
        try {
            const res = await fetch("http://localhost:8080/api/students/add", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(studentData),
            });

            if (res.ok) {
                return {message: "Student added successfully!", flag: true};
            } else {
                return {message: "Failed to add student", flag: true};
            }
        } catch (err) {
            console.error("An error occurred: " + err.messages);
        }
    }

    // Function for deleting a student
    async function deleteStudent(studentId) {
        try {
            const res = await fetch(`http://localhost:8080/api/students/${studentId}`, {
                method: "DELETE",
            });

            if (res.ok) {
               return {message: "Student deleted successfully", flag: true};
            } else {
                return {message: "Failed to delete student", flag: false};
            }
        } catch (err) {
            console.error("An error occurred: " + err.message);
        }
    }

    return {
        addStudent,
        deleteStudent
    }
}