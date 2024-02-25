
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class GetTotalAmount {
	private static double ExchangeRate = 7.27;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ATOMPRICE = getTickerPrice("ATOMUSDT");
		double DYMPRICE = getTickerPrice("DYMUSDT");
		double NEARPRICE = getTickerPrice("NEARUSDT");
		double SEIPRICE = getTickerPrice("SEIUSDT");
		double TIAPRICE = getTickerPrice("TIAUSDT");
		double ETHPRICE = getTickerPrice("ETHUSDT");
		double ALTPRICE = getTickerPrice("ALTUSDT");
		double atomSum = ATOMPRICE * 5000;
		double dymSum = DYMPRICE * 3220;
		double nearSum = NEARPRICE * 8567;
		double seiSum = SEIPRICE * 20639;
		double tiaSum = TIAPRICE * 150;
		double ethSum = ETHPRICE * 3.16;
		double altSum = ALTPRICE * 241;
		double sum = atomSum + dymSum + nearSum + seiSum + tiaSum + ethSum;
		System.out.println(String.format("ATOM price:%.3f$", ATOMPRICE));
		System.out.println(String.format("DYM price:%.3f$", DYMPRICE));
		System.out.println(String.format("NEAR price:%.3f$", NEARPRICE));
		System.out.println(String.format("SEI price:%.3f$", SEIPRICE));
		System.out.println(String.format("TIA price:%.3f$", TIAPRICE));
		System.out.println(String.format("ETH price:%.3f$", ETHPRICE));
		System.out.println(String.format("ALT price:%.3f$", ALTPRICE));
		System.out.println(String.format("Total assets:%.2f$,equals to %.2f￥!", sum, sum * ExchangeRate));
		System.out.println("DETAILS:");
		System.out.println(String.format("Atom assets:%.2f$,equals to %.2f￥!", atomSum, atomSum * ExchangeRate));
		System.out.println(String.format("DYM assets:%.2f$,equals to %.2f￥!", dymSum, dymSum * ExchangeRate));
		System.out.println(String.format("NEAR assets:%.2f$,equals to %.2f￥!", nearSum, nearSum * ExchangeRate));
		System.out.println(String.format("SEI assets:%.2f$,equals to %.2f￥!", seiSum, seiSum * ExchangeRate));
		System.out.println(String.format("Tia assets:%.2f$,equals to %.2f￥!", tiaSum, tiaSum * ExchangeRate));
		System.out.println(String.format("ETH assets:%.2f$,equals to %.2f￥!", ethSum, ethSum * ExchangeRate));
		System.out.println(String.format("ALT assets:%.2f$,equals to %.2f￥!", altSum, altSum * ExchangeRate));
	}

	private static double getTickerPrice(String symbol) {
		try {
			URL url = new URL("https://api.binance.com/api/v3/ticker/price?symbol=" + symbol);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// 解析JSON响应
				JSONObject jsonObject = new JSONObject(response.toString());
				return Double.parseDouble(jsonObject.getString("price"));
			} else {
				System.out.println("API请求失败，响应代码：" + responseCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0; // 默认返回0
	}
}
