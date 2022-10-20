import org.springframework.web.util.UriComponentsBuilder;

public class Springtest {

	public static void main(String[] args) {
		
		String uri = "http://localhost:8080/api/cpm/entity/agent-code/send-otp/{agentCode}";
		
		System.out.println(UriComponentsBuilder.fromUriString(uri).buildAndExpand(123).toUriString());
	}
	
}
