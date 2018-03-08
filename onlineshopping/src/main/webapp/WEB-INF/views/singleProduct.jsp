<div class="container">
	<!-- Breadcrumb  -->
	
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
				<li class="breadcrumb-item"><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="breadcrumb-item active">${product.name}</li>
			</ol>
		
		</div>
		
		<div class="row">
			<!-- Display the product image -->
			<div class="col-xs-12 col-md-4">
				<div class="thumbnail">
					<img src="${images}/${product.code}.jpg" class="img img-responsive">
				</div>
			</div>
			
			<!-- Display the product description -->
			<div class="col-xs-12 col-md-8">
				<h3>${product.name}</h3>
				<hr/>
				
				<p>${product.description}</p>
				<hr/>
				
				<h4>Price : <strong> &#8377; ${product.unitPrice} /-</strong></h4>
				
				
				
				<c:choose>
					<c:when test="${product.quantity < 1}">
					
						<h5>Qty. Available : <span style="color:red">Out of Stock!</span></h5>
					
						<a href="javascript:void(0)" class="btn btn-primary disabled">
							<strike><span class="glyphicon glyphicon-shopping-cart"></span>&#160;Add to Cart </strike>
						</a> &#160;
						
					</c:when>
					<c:otherwise>
						<h5>Qty. Available : ${product.quantity}</h5>
						<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-primary">
							<span class="glyphicon glyphicon-shopping-cart"></span>&#160;Add to Cart
						</a> &#160;
					</c:otherwise>
				</c:choose>
		
				<a href="${contextRoot}/show/all/products" class="btn btn-success">Back</a>
				
			</div>
		</div>
	</div>


</div>