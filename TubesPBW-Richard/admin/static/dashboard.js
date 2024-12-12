document.addEventListener("DOMContentLoaded", function () {
    const filmContainer = document.createElement("div");
    const films = JSON.parse(localStorage.getItem("films")) || [];

    if (films.length > 0) {
        films.forEach((film, index) => {
            const filmCard = document.createElement("div");
            filmCard.classList.add("film-card");

            filmCard.innerHTML = `
                <h3>${film.judul}</h3>
                <p>Genre: ${film.genre.join(", ")}</p>
                <p>Aktor: <span id="aktor-${index}">${film.aktor}</span></p>
                <img id="poster-${index}" src="${film.posterUrl}" alt="${film.judul}" style="width:200px;height:auto;">
                <button class="edit-film" data-index="${index}">Edit</button>
                <button class="delete-film" data-index="${index}">Delete</button>
            `;

            filmCard.style.border = "1px solid #ccc";
            filmCard.style.padding = "10px";
            filmCard.style.margin = "10px 0";
            filmCard.style.position = "relative";

            filmContainer.appendChild(filmCard);
        });
    } else {
        filmContainer.textContent = "Belum ada film yang ditambahkan.";
    }

    document.querySelector("main").appendChild(filmContainer);

    // Event Listener untuk Tombol Delete
    document.querySelectorAll(".delete-film").forEach((button) => {
        button.addEventListener("click", function () {
            const index = parseInt(this.getAttribute("data-index"), 10);
            const updatedFilms = JSON.parse(localStorage.getItem("films")) || [];
            updatedFilms.splice(index, 1); // Hapus film berdasarkan index
            localStorage.setItem("films", JSON.stringify(updatedFilms)); // Perbarui localStorage
            window.location.reload(); // Refresh halaman untuk memperbarui tampilan
        });
    });

    // Event Listener untuk Tombol Edit
    document.querySelectorAll(".edit-film").forEach((button) => {
        button.addEventListener("click", function () {
            const index = parseInt(this.getAttribute("data-index"), 10);
            const films = JSON.parse(localStorage.getItem("films")) || [];
            const film = films[index];

            // Tampilkan Modal untuk Edit
            const modal = document.createElement("div");
            modal.classList.add("modal");

            modal.innerHTML = `
                <div class="modal-content">
                    <h2>Edit Film</h2>
                    <label for="edit-aktor">Aktor:</label>
                    <input type="text" id="edit-aktor" value="${film.aktor}">
                    
                    <label for="edit-poster">Cover Film:</label>
                    <input type="file" id="edit-poster" accept="image/*">
                    
                    <button id="save-edit">Simpan</button>
                    <button id="cancel-edit">Batal</button>
                </div>
            `;

            document.body.appendChild(modal);

            // Simpan Perubahan
            document.getElementById("save-edit").addEventListener("click", function () {
                const newActor = document.getElementById("edit-aktor").value;
                const newPosterInput = document.getElementById("edit-poster");
                const file = newPosterInput.files[0];

                if (newActor) {
                    film.aktor = newActor; // Perbarui aktor
                    document.getElementById(`aktor-${index}`).textContent = newActor;
                }

                if (file) {
                    const reader = new FileReader();
                    reader.onload = function (e) {
                        film.posterUrl = e.target.result; // Perbarui URL poster
                        document.getElementById(`poster-${index}`).src = e.target.result;
                        localStorage.setItem("films", JSON.stringify(films)); // Simpan perubahan
                    };
                    reader.readAsDataURL(file);
                } else {
                    localStorage.setItem("films", JSON.stringify(films)); // Simpan tanpa perubahan poster
                }

                document.body.removeChild(modal); // Tutup modal
            });

            // Batalkan Perubahan
            document.getElementById("cancel-edit").addEventListener("click", function () {
                document.body.removeChild(modal); // Tutup modal
            });
        });
    });
});
