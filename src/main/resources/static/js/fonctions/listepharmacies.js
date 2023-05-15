$(document).ready(
		function () {

			 table = $('#tpharmacie')
				.DataTable({
					ajax: {
						url: "pharmacies/all?InInvoiId=123456",
						dataSrc: '',
						
					},
					columnDefs:[{
						"targets":1,
						"render":function(data){
							return '<img src = "data:image/jpeg;base64,'+data.photo +'"height="100" width ="100" alt="' +data.nom+'"/>';
						}
					},
					],
					
					columns: [
						{
							data: "id"
						},
						{
							data:null
						},
						{
							data: "nom"
						},
						{
							data: "adresse"
						},
						{
							data: "etat"
						},
						
						{
							data: "zone.nom"
						},
						{
							"render": function () {
								return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
							}
						},
						{
							"render": function () {
								return '<button type="button" class="btn btn-outline-secondary modifier">Modifier</button>';
							}
						}]
				});
				 
					
		
				 


			function remplir(data) {
			 var contenu = $('#table-content');
			var ligne = "";
			for (i = 0; i < data.length; i++) {
			ligne += '<tr><th scope="row">' + data[i].id + '</th>';
			ligne += '<td>' + data[i].nom + '</td>';
			 ligne += '<td>' + data[i].adresse + '</td>';
			ligne += '<td>' + data[i].etat + '</td>';
			  ligne += '<td>' + data[i].zone.nom + '</td>';
			ligne += '<td><button type="button" class="btnbtn-outline-dangersupprimer">Supprimer</button></td>';
			ligne += '<td><button type="button" class="btnbtn-outline-secondarymodifier">Modifier</button></td></tr>';
			}
			contenu.html(ligne);
			}
			 $.ajax({
			url: 'pharmacies/all',
			 data: {op: ''},
			type: 'GET',
		async: false,
			success: function (data, textStatus, jqXHR) {
			console.log(data);
			remplir(data);
			 },
			 error: function (jqXHR, textStatus, errorThrown) {
			 console.log(textStatus);
			 }
			});
		}); 

			$('#btn').click(
				function () {
					var nom = $("#nom");
					var adresse = $("#adresse");
					var etat = $("#etat");
					
					var zone = $("#zone");
					if ($('#btn').text() == 'Ajouter') {
						var p = {
							nom: nom.val(),
							adresse: adresse.val(),
							latitude: latitude.val(),
							longitude: longitude.val(),
							zone: {
								id: zone.val()
							}
							};
						  var formData = new FormData();
						  formData.append('image', $('#image')[0].files[0]);
							formData.append('nom', p.nom);
							formData.append('adresse', p.adresse);
							formData.append('latitude', p.latitude);
							formData.append('longitude', p.longitude);
							formData.append('zoneid', p.zone.id);
						  $.ajax({
						    url: 'pharmacies/save',
						    type: 'POST',
						    data: formData,
						    contentType: false,
						    processData: false,
						    success: function(response) {
						      console.log(response);
						    }
						  });
						
						$("#main-content").load(
							"./page/pharmacie.html");
					}
				});

			$('#table-content')
				.on(
					'click',
					'.supprimer',
					function () {

						var id = $(this).closest('tr').find(
							'td').eq(0).text();
						var oldLing = $(this).closest('tr')
							.clone();
						var newLigne = '<tr style="position: relative;" class="bg-light" ><th scope="row">'
							+ id
							+ '</th><td colspan="4" style="height: 100%;">';
						newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer cette pharmacie ? </h4>';
						newLigne += '<button type="button" class="btn btn-outline-primary btn-sm confirmer" style="margin-left: 25px;">Oui</button>';
						newLigne += '<button type="button" class="btn btn-outline-danger btn-sm annuler" style="margin-left: 25px;">Non</button></td></tr>';

						$(this).closest('tr').replaceWith(
							newLigne);
						$('.annuler').click(
							function () {
								$(this).closest('tr')
									.replaceWith(
										oldLing);
							});
						$('.confirmer')
							.click(
								function (e) {
									e.preventDefault();
									$
										.ajax({
											url: 'pharmacies/delete/'
												+ id,
											data: {},
											type: 'DELETE',
											async: false,
											success: function (
												data,
												textStatus,
												jqXHR) {
												if (data
													.includes("error") == true) {
													$(
														"#error")
														.modal();
												} else {
													table.ajax
														.reload();
												}
											},
											error: function (
												jqXHR,
												textStatus,
												errorThrown) {
												$(
													"#error")
													.modal();
											}
										});
								});

					});

			$('#table-content').on(
				'click',
				'.modifier',
				function () {
					let etat=$(this).closest('tr').find('td').eq(4)
						
					if($(this).text()=="Modifier"){
						$(this).text("confirmer")
						etat.html("<select id='etat'><option value='En_Attente'>En_Attente</option> <option value='Valider'>Valider </option> <option value='Refuser' >Refuser</option> </select>")
					}else {
						let id_etat=etat.children()
						etat.html(id_etat.val())
						$(this).text("Modifier")
					}
					
					/*
					var btn = $('#btn');
					var id = $(this).closest('tr').find('td').eq(0)
						.text();
					;
					var nom = $(this).closest('tr').find('td').eq(
						1).text();
					var adresse = $(this).closest('tr').find('td')
						.eq(2).text();
					var latitude = $(this).closest('tr').find('td').eq(
						3).text();
					var longitude = $(this).closest('tr').find('td').eq(
						4).text();
					var zone = $(this).closest('tr').find('td')
						.eq(5).text();

					btn.text('Modifier');
					$("#nom").val(nom);
					$("#adresse").val(adresse);
					$("#id").val(id);
					$("#latitude").val(latitude);
					$("#longitude").val(longitude);
					var op = $('#zone option').filter(function () { return $(this).html() == zone; }).val();
					$("#zone").val(op);

					btn.click(function (e) {
						e.preventDefault();
						var p = {
							id: $("#id").val(),
							nom: $("#nom").val(),
							adresse: $("#adresse").val(),
							latitude: $("#latitude").val(),
							longitude: $("#longitude").val(),
							zone: {
								id: $("#zone").val()

							}

						};
						alert(p)
						if ($('#btn').text() == 'Modifier') {
							$.ajax({
								url: 'pharmacies/save',
								contentType: "application/json",
								dataType: "json",
								data: JSON.stringify(p),
								type: 'POST',
								async: false,
								success: function (data,
									textStatus, jqXHR) {
									table.ajax.reload();
									$("#nom").val('');
									$("#adresse").val('');
									$("#zone").val('');
									btn.text('Ajouter');
								},
								error: function (jqXHR, textStatus,
									errorThrown) {
									console.log(textStatus);
								}
							});
							$("#main-content").load(
								"./page/pharmacie.html");
						}
					});
				*/});
				
