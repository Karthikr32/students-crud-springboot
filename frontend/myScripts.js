async function showAvailableCourses() {
  await fetch("http://localhost:8080/courses")
    .then((response) => response.json())
    .then((data) => {
      const AvailableCourseTable = document.getElementById(
        "available-course-tbody"
      );

      let tableRow = "";
      data.forEach((course) => {
        tableRow += `
      <tr>
      <td>${course.id}</td>
      <td>${course.courseName}</td>
      <td>${course.trainer}</td>
      <td>${course.durationInWeeks}</td>
      </tr>
      `;
      });

      AvailableCourseTable.innerHTML = tableRow;
    });
}

function dateFormat(arrDate) {
  const date = new Date(arrDate);
  const day = String(date.getDate()).padStart(2, "0"); // means, the String has atleast 2 character if any of it less than 2 means, this will pad with '0'
  const month = String(date.getMonth()).padStart(2, "0");
  const year = String(date.getFullYear());

  return `${day}-${month}-${year}`;
}

async function showEnrolledDetails() {
  await fetch("http://localhost:8080/courses/enrolled")
    .then((response) => response.json())
    .then((datas) => {
      const enrolledCourseTable = document.getElementById(
        "enrolled-course-tbody"
      );

      let tableRow = "";

      datas.forEach((data) => {
        tableRow += `
      <tr id="row${data.id}">
        <td>${data.id}</td>
        <td>${dateFormat(data.date)}</td>
        <td>${data.name}</td>
        <td>${data.mobileNum}</td>
        <td>${data.emailId}</td>
        <td>${data.location}</td>
        <td>${data.courseName}</td>
        <td>${data.batchTime}</td>
        <td>${data.profession}</td>
        <td>${data.interestedInTrainer}</td>
        <td><i class="fa-solid fa-trash" id="delbtn" onclick="delStudent(${
          data.id
        })"></i></td>
      </tr>`;
      });

      enrolledCourseTable.innerHTML = tableRow;
    });
}

const form = document.querySelector("#form");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const date = document.querySelector("#date");
  const name = document.querySelector("#name");
  const mobileNum = document.querySelector("#num");
  const emailId = document.querySelector("#mail");
  const location = document.querySelector("#map");
  const courseName = document.querySelector("#select-course");
  const batchTime = document.querySelector('input[name="batchTime"]:checked');
  const profession = document.querySelector('input[name="profession"]:checked');
  const interestedInTrainer = document.querySelector(
    'input[name="interestedInTrainer"]:checked'
  );

  const userData = {
    date: date.value,
    name: name.value,
    mobileNum: mobileNum.value,
    emailId: emailId.value,
    location: location.value,
    courseName: courseName.value,
    batchTime: batchTime.value,
    profession: profession.value,
    interestedInTrainer: interestedInTrainer.value,
  };

  try {
    const response = await fetch("http://localhost:8080/courses/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userData),
    });

    const responseData = await response.json();

    if (response.ok) {
      // we can't pass 2 arg via alert, bcz it takes the 1st one & ignores the 2nd one
      alert("Success: " + `${responseData.message}`);
      form.reset();
    } 
    else {
      alert("Error: " + `${responseData.error}`);
    }
  } catch (err) {
    alert("Network/Unexpected error: " + `${err}`);
    console.log(err);
  }
});

async function delStudent(id) {
  try {
    const response = await fetch(`http://localhost:8080/courses/${id}`, {
      method: "DELETE",
    });

    if (response.ok) {
      document.querySelectorAll("#enrolled-course-tbody tr").forEach((item) => {
        if (item.id === `row${id}`) {
          item.remove();
        } else {
          console.log("Id mismatched");
        }
      });
      alert("Deleted successfully");
    } 
    else {
      alert("Error occurred, try again later");
    }
  } catch (err) {
    console.log("Error occured ", err);
  }
}
