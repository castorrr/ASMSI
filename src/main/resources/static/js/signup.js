document.addEventListener("DOMContentLoaded", function () {
  const signupContainer = document.getElementById("signup-container");
  const backToLoginBtn = document.getElementById("back-to-login");

  // Add animation on page load (Signup form slides in, modal expands)
  setTimeout(() => {
    signupContainer.classList.add("signup-active");
  }, 100);

  // Handle back to login animation
  if (backToLoginBtn) {
    backToLoginBtn.addEventListener("click", function (event) {
      event.preventDefault(); // Prevent immediate redirection

      signupContainer.classList.remove("signup-active");
      signupContainer.classList.add("signup-reverse"); // Add reverse animation

      setTimeout(() => {
        window.location.href = "/login"; // Redirect after animation
      }, 500);
    });
  }
});

function togglePassword() {
  var passwordField = document.getElementById("password");
  var icon = document.querySelector(".toggle-password i");

  if (passwordField.type === "password") {
    passwordField.type = "text";
    icon.classList.remove("glyphicon-eye-open");
    icon.classList.add("glyphicon-eye-close");
  } else {
    passwordField.type = "password";
    icon.classList.remove("glyphicon-eye-close");
    icon.classList.add("glyphicon-eye-open");
  }
}
