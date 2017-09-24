<link rel = "Shortcut Icon" href="${rc.contextPath}/public/propaganda/favicon.ico"/>
<link type="image/x-icon" href="${rc.contextPath}/public/propaganda/favicon.ico" rel="Bookmark"/>
<link type="image/x-icon" href="${rc.contextPath}/public/propaganda/favicon.ico" rel="Shortcut Icon"/>
<link rel="stylesheet" href="${rc.contextPath}/public/propaganda/css/reset.css"/>
<link rel="stylesheet" href="${rc.contextPath}/public/propaganda/css/main.css"/>
<script type="text/javascript">
	<#if publicKeyExponent?? && publicKeyModulus??>
		ENCYPT_PUBLIC_KEY_Exponent = "${publicKeyExponent}";
		ENCYPT_PUBLIC_KEY_Modulus = "${publicKeyModulus}"
	</#if>
</script>

