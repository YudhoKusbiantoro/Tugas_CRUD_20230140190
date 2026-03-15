// API Base URL - PERUBAHAN PENTING!
const API_URL = '/ktp';  // Relative path (bukan http://localhost:8080/ktp)

// Document Ready
$(document).ready(function() {
    // Load data saat halaman pertama kali dibuka
    loadData();

    // Form Submit Handler
    $('#ktpForm').on('submit', function(e) {
        e.preventDefault();
        submitForm();
    });

    // Reset Button Handler
    $('#btnReset').on('click', function() {
        resetForm();
    });

    // Cancel Button Handler
    $('#btnCancel').on('click', function() {
        cancelEdit();
    });

    // Refresh Button Handler
    $('#btnRefresh').on('click', function() {
        loadData();
    });

    // Close Notification
    $('#notifClose').on('click', function() {
        hideNotification();
    });
});

// Function to Load All Data
function loadData() {
    $('#loading').show();
    $('#noData').hide();
    $('#tableBody').empty();

    $.ajax({
        url: API_URL,
        method: 'GET',
        success: function(response) {
            $('#loading').hide();

            if (response.success && response.data.length > 0) {
                displayData(response.data);
            } else {
                $('#noData').show();
            }
        },
        error: function(xhr, status, error) {
            $('#loading').hide();
            showNotification('Error mengambil data: ' + error, 'error');
            console.error('Error:', error);
        }
    });
}

// Function to Display Data in Table
function displayData(data) {
    $('#tableBody').empty();

    data.forEach((item, index) => {
        const row = `
            <tr>
                <td>${index + 1}</td>
                <td>${item.nomorktp}</td>
                <td>${item.namalengkap}</td>
                <td>${item.alamat}</td>
                <td>${formatDate(item.tanggallahir)}</td>
                <td>${item.jeniskelamin === 'L' ? 'Laki-laki' : 'Perempuan'}</td>
                <td>
                    <div class="action-buttons">
                        <button class="btn btn-warning btn-sm" onclick="editData(${item.id})">
                            ✏️ Edit
                        </button>
                        <button class="btn btn-danger btn-sm" onclick="deleteData(${item.id})">
                            🗑️ Hapus
                        </button>
                    </div>
                </td>
            </tr>
        `;
        $('#tableBody').append(row);
    });
}

// Function to Submit Form (Create/Update)
function submitForm() {
    const id = $('#id').val();
    const formData = {
        nomorktp: $('#nomorktp').val(),
        namalengkap: $('#namalengkap').val(),
        alamat: $('#alamat').val(),
        tanggallahir: $('#tanggallahir').val(),
        jeniskelamin: $('#jeniskelamin').val()
    };

    // Validation
    if (!formData.nomorktp || formData.nomorktp.length !== 16) {
        showNotification('Nomor KTP harus 16 digit!', 'error');
        return;
    }

    if (!formData.namalengkap) {
        showNotification('Nama lengkap harus diisi!', 'error');
        return;
    }

    if (!formData.alamat) {
        showNotification('Alamat harus diisi!', 'error');
        return;
    }

    if (!formData.tanggallahir) {
        showNotification('Tanggal lahir harus diisi!', 'error');
        return;
    }

    if (!formData.jeniskelamin) {
        showNotification('Jenis kelamin harus dipilih!', 'error');
        return;
    }

    // Determine if Create or Update
    const url = id ? `${API_URL}/${id}` : API_URL;
    const method = id ? 'PUT' : 'POST';
    const message = id ? 'Data berhasil diperbarui!' : 'Data berhasil ditambahkan!';

    $.ajax({
        url: url,
        method: method,
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function(response) {
            if (response.success) {
                showNotification(message, 'success');
                resetForm();
                loadData();
            } else {
                showNotification(response.message || 'Terjadi kesalahan!', 'error');
            }
        },
        error: function(xhr, status, error) {
            const errorMsg = xhr.responseJSON ? xhr.responseJSON.message : error;
            showNotification('Error: ' + errorMsg, 'error');
            console.error('Error:', error);
        }
    });
}

// Function to Edit Data
function editData(id) {
    $.ajax({
        url: `${API_URL}/${id}`,
        method: 'GET',
        success: function(response) {
            if (response.success) {
                const data = response.data;

                // Fill form with data
                $('#id').val(data.id);
                $('#nomorktp').val(data.nomorktp);
                $('#namalengkap').val(data.namalengkap);
                $('#alamat').val(data.alamat);
                $('#tanggallahir').val(data.tanggallahir);
                $('#jeniskelamin').val(data.jeniskelamin);

                // Change form title and buttons
                $('#formTitle').text('Edit Data KTP');
                $('#btnSubmit').text('💾 Update');
                $('#btnCancel').show();

                // Scroll to form
                $('html, body').animate({
                    scrollTop: $('.form-container').offset().top - 20
                }, 500);

                showNotification('Silakan edit data', 'info');
            }
        },
        error: function(xhr, status, error) {
            showNotification('Error mengambil data: ' + error, 'error');
            console.error('Error:', error);
        }
    });
}

// Function to Delete Data
function deleteData(id) {
    if (confirm('Apakah Anda yakin ingin menghapus data ini?')) {
        $.ajax({
            url: `${API_URL}/${id}`,
            method: 'DELETE',
            success: function(response) {
                if (response.success) {
                    showNotification('Data berhasil dihapus!', 'success');
                    loadData();
                } else {
                    showNotification(response.message || 'Gagal menghapus data!', 'error');
                }
            },
            error: function(xhr, status, error) {
                const errorMsg = xhr.responseJSON ? xhr.responseJSON.message : error;
                showNotification('Error: ' + errorMsg, 'error');
                console.error('Error:', error);
            }
        });
    }
}

// Function to Reset Form
function resetForm() {
    $('#ktpForm')[0].reset();
    $('#id').val('');
    $('#formTitle').text('Tambah Data KTP');
    $('#btnSubmit').text('💾 Simpan');
    $('#btnCancel').hide();
}

// Function to Cancel Edit
function cancelEdit() {
    resetForm();
}

// Function to Show Notification
function showNotification(message, type = 'info') {
    const $notif = $('#notification');
    const $message = $('#notifMessage');

    $notif.removeClass('success error info');
    $notif.addClass(type + ' show');
    $message.text(message);

    // Auto hide after 5 seconds
    setTimeout(function() {
        hideNotification();
    }, 5000);
}

// Function to Hide Notification
function hideNotification() {
    $('#notification').removeClass('show');
}

// Function to Format Date
function formatDate(dateString) {
    if (!dateString) return '-';

    const date = new Date(dateString);
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    return date.toLocaleDateString('id-ID', options);
}