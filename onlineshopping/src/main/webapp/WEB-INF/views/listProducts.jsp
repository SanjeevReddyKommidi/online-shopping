<div class="container">
	<div class="row">
	
		<!-- To display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		
		<!-- To display the actual products -->
		<div class="col-md-9">
			<!-- Added breadcrumb component -->
			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClicksAllProducts == true}" >
					
						<script>
							window.categoryId = '';
						</script> 
						
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">All Products</li>
						</ol>
					</c:if>
					
					<c:if test="${userClicksCategoryProducts == true}" >
						<script>
							window.categoryId = '${category.id}';
						</script>
						
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Category</li>
							<li class="breadcrumb-item active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12">
					<table id="productListTable" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>
						</tfoot>
						
					</table>
				</div>
			</div>
		
		</div>
	</div>
</div>