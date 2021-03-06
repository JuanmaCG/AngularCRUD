//PACKAGE COM.MAIN.AUTH;
//
//IMPORT JAVA.UTIL.COLLECTIONS;
//IMPORT JAVA.UTIL.DATE;
//
//IMPORT JAVAX.SERVLET.HTTP.HTTPSERVLETREQUEST;
//IMPORT JAVAX.SERVLET.HTTP.HTTPSERVLETRESPONSE;
//
//IMPORT ORG.SPRINGFRAMEWORK.SECURITY.AUTHENTICATION.USERNAMEPASSWORDAUTHENTICATIONTOKEN;
//IMPORT ORG.SPRINGFRAMEWORK.SECURITY.CORE.AUTHENTICATION;
//
//IMPORT IO.JSONWEBTOKEN.JWTS;
//IMPORT IO.JSONWEBTOKEN.SIGNATUREALGORITHM;
//
//PUBLIC CLASS TOKEN {
//	
//	// VAMOS A ASIGNAR UN TIEMPO DE EXPIRACION DE 10 DIAS
//	STATIC FINAL LONG EXPIRATION_TIME = 860_000_000;
//	STATIC FINAL STRING SECRET = "MYSECRET";
//	STATIC FINAL STRING TOKEN_PREFIX = "BEARER";
//	STATIC FINAL STRING HEADER_STRING = "AUTHORIZATION";
//	
//	STATIC VOID ADDAUTHENTICATION(HTTPSERVLETRESPONSE RESPONSE, STRING USERNAME) {
//		STRING JWT = JWTS.BUILDER()
//				.SETSUBJECT(USERNAME)
//				.SETEXPIRATION(NEW DATE(SYSTEM.CURRENTTIMEMILLIS() + EXPIRATION_TIME))
//				.SIGNWITH(SIGNATUREALGORITHM.HS512, SECRET)
//				.COMPACT();
//		
//		//AGREGAMOS AL ENCABEZADO EL TOKEN
//		RESPONSE.ADDHEADER(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
//	}
//	
//    // M�TODO PARA VALIDAR EL TOKEN ENVIADO POR EL CLIENTE
//	STATIC AUTHENTICATION GETAUTHENTICATION(HTTPSERVLETREQUEST REQUEST) {
//		 // OBTENEMOS EL TOKEN QUE VIENE EN EL ENCABEZADO DE LA PETICION	
//		STRING TOKEN = REQUEST.GETHEADER(HEADER_STRING);
//		
//		// SI HAY UN TOKEN PRESENTE, ENTONCES LO VALIDAMOS
//		IF (TOKEN != NULL) {
//			// FAZ PARSE DO TOKEN
//			STRING USER = JWTS.PARSER()
//					.SETSIGNINGKEY(SECRET)
//					.PARSECLAIMSJWS(TOKEN.REPLACE(TOKEN_PREFIX, "")) //ESTE METODO ES EL QUE VALIDA
//					.GETBODY()
//					.GETSUBJECT();
//			
//			// RECORDAMOS QUE PARA LAS DEM�S PETICIONES QUE NO SEAN /LOGIN
//            // NO REQUERIMOS UNA AUTENTICACION POR USERNAME/PASSWORD 
//            // POR ESTE MOTIVO PODEMOS DEVOLVER UN USERNAMEPASSWORDAUTHENTICATIONTOKEN SIN PASSWORD
//			IF (USER != NULL) {
//				RETURN NEW USERNAMEPASSWORDAUTHENTICATIONTOKEN(USER, NULL, COLLECTIONS.EMPTYLIST());
//			}
//		}
//		RETURN NULL;
//	}
//	
//}