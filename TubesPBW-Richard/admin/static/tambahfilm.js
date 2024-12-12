document.getElementById("submit-film").addEventListener("click", function () {
    const judul = document.getElementById("judul").value;
    const genre = document.getElementById("genre").value.split(",");
    const aktor = document.getElementById("aktor").value;
    const posterInput = document.getElementById("poster");
    const poster = posterInput.files[0];

    if (judul && genre && aktor && poster) {
        const reader = new FileReader();
        reader.onload = function (e) {
            const filmData = {
                judul: judul,
                genre: genre,
                aktor: aktor,
                posterUrl: e.target.result,
            };
            // Simpan data ke localStorage untuk simulasi
            const existingData = JSON.parse(localStorage.getItem("films")) || [];
            existingData.push(filmData);
            localStorage.setItem("films", JSON.stringify(existingData));

            alert("Film berhasil ditambahkan!");
            window.location.href = "dashboard.html";
        };
        reader.readAsDataURL(poster);
    } else {
        alert("Harap lengkapi semua data!");
    }
});
