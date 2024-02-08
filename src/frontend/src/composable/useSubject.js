export function useSubject() {
    // Function for adding a subject
    async function addSubject(subjectData) {
        try {
            const res = await fetch("http://localhost:8080/api/subjects/add", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(subjectData),
            });

            if (res.ok) {
                return {message: "Subject added successfully!", flag: true};
            } else {
                return {message: "Failed to add Subject", flag: false};
            }
        } catch (err) {
            console.error("An error occurred: " + err.messages);
        }
    }


    // Function for deleting a subject
    async function deleteSubject(subjectId) {
        try {
            const res = await fetch(`http://localhost:8080/api/subjects/${subjectId}`, {
                method: "DELETE",
            });

            if (res.ok) {
                return {message: "Subject deleted successfully!", flag: true};
            } else {
                return {message: "Failed to delete subject", flag: false};
            }
        } catch (err) {
            console.error("An error occurred: " + err.message);
        }
    }

    // Function for getting all subjects
    async function getAllSubjects() {
        try {
            const res = await fetch("http://localhost:8080/api/subjects/get", {
                method: "GET",
            });

            if (res.ok) {
                return {message: await res.json(), flag: true};
            } else {
                return {message: "Failed to fetch Subjects", flag: false};
            }
        } catch (err) {
            console.error("An error occurred: " + err.messages);
        }
    }

    // Function for getting a specific object
    async function getSubjectById(subjectId) {
        try {
            const res = await fetch(`http://localhost:8080/api/subjects/${subjectId}`, {
                method: "GET",
            });

            if (res.ok) {
                return {message: await res.json(), flag: true};
            } else {
                return {message: "Failed to fetch Subjects", flag: false};
            }
        } catch (err) {
            console.error("An error occurred: " + err.messages);
        }
    }

    // Function for getting subjects and grades for a student
    async function getSubjectsAndGradesForStudent(studentId) {
        try {
            const res = await fetch(`http://localhost:8080/api/subjects/sbj/${studentId}`, {
                method: 'GET'
            });

            if (res.ok) {
                return {message: await res.json(), flag: true};
            } else {
                return {message: "Failed to fetch subject and grades for the student", flag: false};
            }

        } catch (err) {
            console.error("An error occurred: " + err.messages);
        }
    }

    // Function for getting average grades for each subject
    async function getSubjectsAndAverageGrades() {
        try {
            const res = await fetch('http://localhost:8080/api/subjects/average-grades', {
                method: 'GET'
            });

            if (res.ok) {
                return {message: await res.json(), flag: true};
            } else {
                return {message: "Failed to fetch average grades for the subjects", flag: false};
            }

        } catch (err) {
            console.error("An error occurred: " + err.messages);
        }
    }

    return {
        addSubject,
        deleteSubject,
        getAllSubjects,
        getSubjectById,
        getSubjectsAndGradesForStudent,
        getSubjectsAndAverageGrades
    }
}