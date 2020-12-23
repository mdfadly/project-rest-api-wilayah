var tableProvinsi = {
	create: function() {
		$.ajax({
			url: '/provinsi/get-all',
			method: 'get',
			contentType: 'application/json',
			success: function(res, status, xhr) {
				data = "";
				$.each(res, function(index, value) {
					data += "<tr>";
					data += "<td>" + (index + 1) + "</td>";
					data += "<td>" + value.provinsiCode + "</td>";
					data += "<td>" + value.provinsiName + "</td>";
					data += "<td>" + value.status + "</td>";
					data += "</tr>";
				});
				$('#body-person').append(data);
			},
			error: function(e) {
				alert(e);
				console.log(e);
			}
		});
	},
	getProvinsi: function() {
		$.ajax({
			method: 'get',
			url: '/provinsi/get-all',
			contentType: 'application/json',
			success: function(res, status, xhr) {
				if (xhr.status == 200 || xhr.status == 201) {
					console.log(res);
					$('#table-provinsi').DataTable({
						data: res,
						columns: [{
							title: "id",
							data: "id"
						},
						{
							title: "Provinsi Code",
							data: "provinsiCode"
						},
						{
							title: "Provinsi Name",
							data: "provinsiName"
						},
						{
							title: "Status",
							data: "status"
						},
						{
							title: "Action",
							data: null,
							render: function(data, type, row) {
								return "<button class='btn btn-primary mr-2' onclick=formProvinsi.setEditData('" + data.id + "')>Edit</button> | <button class='btn btn-danger ml-2' onclick=formProvinsi.deleteData('" + data.id + "')>Delete</button>";
							}
						}]
					});
				}else{}
			}
		});
	}
}

var formProvinsi = {
	save: function() {
		var provinsi = {};
		provinsi["provinsiCode"] = $('#provinsiCode').val();
		provinsi["provinsiName"] = $('#provinsiName').val();
		$.ajax({
			method: 'post',
			url: '/provinsi/insert-provinsi',
			contentType: 'application/json',
			data: JSON.stringify(provinsi),
			success: function(res) {
				console.log(res);
			}
		})
	},
	setEditData: function(id) {
		$.ajax({
			method: 'get',
			url: '/provinsi/get-by-id/' + id,
			contentType: 'application/json',
			type: 'json',
			success: function(res) {
				console.log(res);
				$('#provinsiName').val(res.provinsiName);
				$('#provinsiCode').val(res.provinsiCode);
			
				$('#btn-save').off('click').on('click', function(){
					formProvinsi.update(res.id);
					tableProvinsi.getProvinsi;
					$('#btn-save').off('click').on('click', function(){
						formProvinsi.save;
					})
				})
			}
		})
	},
	update: function(id){
		var provinsi = {};
		provinsi["provinsiCode"] = $('#provinsiCode').val();
		provinsi["provinsiName"] = $('#provinsiName').val();
		$.ajax({
			method: 'put',
			url: '/provinsi/update-provinsi/' + id,
			contentType: 'application/json',
			data: JSON.stringify(provinsi),
			success: function(res) {
				console.log(res);
			}
		})
	},
	
	deleteData: function(id){
		$.ajax({
			method: 'delete',
			url: '/provinsi/delete-provinsi/' + id,
			contentType: 'application/json',
			success: function(res) {
				alert("Deleted!");
				location.reload();
			}
		})
	}
}

