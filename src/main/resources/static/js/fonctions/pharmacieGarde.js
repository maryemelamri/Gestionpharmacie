$(document)
		.ready(
				function() {

					table = $('#tgarde')
							.DataTable({
										ajax : {
											url : "DureeGarde/all",
											dataSrc : ''
										},
										columns : [
												{
													data : "pharmacie.nom"
												},
												{
													data : "garde.type"
												},
												
												{
													data : "pk.datedebut"
												},
												{
													data : "datefin"
												},
												
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
													}
												},
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-secondary modifier">Modifier</button>';
													}
												} ]

									});
							
		$.ajax({
		url: '/villes/all',
	
		type: 'GET',
		success: function (data) {
			var option = '';
			data.forEach(e => {
				option += '<option value =' + e.nom + '>' + e.nom + '</option>';
			});
			console.table(data);

			$('#ville').append(option);
			//console.log($('#ville').html());

		},
		error: function (jqXHR, textStatus,
			errorThrown) {
			console.log(textStatus);
		}

	});
	
$('#ville').on('change',function(){
	$('#zone').empty()
	$.ajax({
		url: '/villes/zone/'+this.value,
		type: 'GET',
		success: function (data) {
			var option = '';
			data.forEach(e => {
				option += '<option value =' + e.nom + '>' + e.nom + '</option>';
			});

			$('#zone').append(option);
			console.log($('#zone').html());
		},
		error: function (jqXHR, textStatus,
			errorThrown) {
			console.log(textStatus);
		}
})}),
	
$('#zone').on('change',function(){
	$('#pharmacie').empty()
	$.ajax({
		url: '/zones/zone/'+this.value,
		type: 'GET',
		success: function (data) {
			var option = '';
			data.forEach(e => {
				option += '<option value =' + e.id + '>' + e.nom + '</option>';
			});

			$('#pharmacie').append(option);
			console.log($('#pharmacie').html());
		},
		error: function (jqXHR, textStatus,
			errorThrown) {
			console.log(textStatus);
		}
})}),
		
				
					$.ajax({
						url:'/gardes/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.id+'>'+e.type+'</option>';
							});
							
						$('#garde').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});

					$('#btn').click(
							function() {
								var pharmacie = $("#pharmacie");
								var garde = $("#garde");
								var datedebut = $("#datedebut");
								var datefin = $("#datefin");
								
								
								if ($('#btn').text() == 'Ajouter') {
									var p = {
										pk:{
											pharmacie :pharmacie.val(),
											garde : garde.val(),
											datedebut: datedebut.val()
											
										} ,

										datedebut : datedebut.val(),
										datefin : datefin.val(),
										
										pharmacie : {
											id : pharmacie.val()
										},
										garde : {
											id : garde.val()
										}
										
									};

									$.ajax({
										url : 'DureeGarde/save',
										contentType : "application/json",
										dataType : "json",
										data : JSON.stringify(p),
										type : 'POST',
										async : false,
										success : function(data, textStatus,
												jqXHR) {
											table.ajax.reload();
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											console.log(textStatus);
										}
									});
									$("#main-content").load(
											"./page/pharmacieGarde.html");
								}
							});

					$('#table-content')
							.on(
									'click',
									'.supprimer',
									function() {

										var id = $(this).closest('tr').find(
												'td').eq(0).text();
										var oldLing = $(this).closest('tr')
												.clone();
										var newLigne = '<tr style="position: relative;" class="bg-light" ><th scope="row">'
												+ id
												+ '</th><td colspan="4" style="height: 100%;">';
										newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer cette marque ? </h4>';
										newLigne += '<button type="button" class="btn btn-outline-primary btn-sm confirmer" style="margin-left: 25px;">Oui</button>';
										newLigne += '<button type="button" class="btn btn-outline-danger btn-sm annuler" style="margin-left: 25px;">Non</button></td></tr>';

										$(this).closest('tr').replaceWith(
												newLigne);
										$('.annuler').click(
												function() {
													$(this).closest('tr')
															.replaceWith(
																	oldLing);
												});
										$('.confirmer')
												.click(
														function(e) {
															e.preventDefault();
															$
																	.ajax({
																		url : '/delete/'
																				+ id,
																		data : {},
																		type : 'DELETE',
																		async : false,
																		success : function(
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
																		error : function(
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
							function() {
								var btn = $('#btn');
								
								
								var pharmacie = $(this).closest('tr').find('td').eq(
										0).text();
								var garde = $(this).closest('tr').find('td')
										.eq(1).text();
								var datedebut = $(this).closest('tr').find('td')
										.eq(2).text();
								var datefin = $(this).closest('tr').find('td')
								.eq(3).text();
							
								
								btn.text('Modifier');
								var op = $('#pharmacie option').filter(function () { return $(this).html() == pharmacie; }).val();
								$("#pharmacie").val(op);
								$("#id").val(id);
								var op1 = $('#garde option').filter(function () { return $(this).html() == garde; }).val();
								$("#garde").val(op1);
								$("#id").val(id);
								$("#datedebut").val(datedebut);
								$("#datefin").val(datefin);
								
								
								btn.click(function(e) {
									e.preventDefault();
									var p = {
										id : $("#id").val(),
										datedebut: $("#datedebut").val(),
										datefin : $("#datefin").val(),
										
										pharmacie : {
											id : $("#pharmacie").val()
											
										},
										garde : {
											id : $("#garde").val()
											
										}
										
										
									};
									if ($('#btn').text() == 'Modifier') {
										$.ajax({
											url : 'DureeGarde/save',
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'POST',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												table.ajax.reload();
												$("#pharmacie").val('');
												$("#garde").val('');
												$("#datedebut").val('');
												$("#datefin").val('');
												btn.text('Ajouter');
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);
											}
										});
										$("#main-content").load(
												"./page/pharmacieGarde.html");
									}
								});
							});

					
				});
