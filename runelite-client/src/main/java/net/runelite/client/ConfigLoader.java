/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import net.runelite.http.api.RuneliteAPI;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConfigLoader
{
	private static final OkHttpClient CLIENT = RuneliteAPI.CLIENT;
	private static final HttpUrl CONFIG_URL = HttpUrl.parse("http://oldschool.runescape.com/jav_config.ws"); // https redirects us to rs3

	public static final String CODEBASE = "codebase";
	public static final String INITIAL_JAR = "initial_jar";
	public static final String INITIAL_CLASS = "initial_class";

	private final Map<String, String> properties = new HashMap<>(),
		appletProperties = new HashMap<>();

	public void fetch() throws IOException
	{
		Request request = new Request.Builder()
			.url(CONFIG_URL)
			.build();

		try (Response response = CLIENT.newCall(request).execute();
			BufferedReader in = new BufferedReader(new InputStreamReader(response.body().byteStream())))
		{
			String str;

			while ((str = in.readLine()) != null)
			{
				int idx = str.indexOf('=');

				if (idx == -1)
				{
					continue;
				}

				String s = str.substring(0, idx);

				if (s.equals("param"))
				{
					str = str.substring(idx + 1);
					idx = str.indexOf('=');
					s = str.substring(0, idx);

					appletProperties.put(s, str.substring(idx + 1));
				}
				else if (s.equals("msg"))
				{
					// ignore
				}
				else
				{
					properties.put(s, str.substring(idx + 1));
				}
			}
		}
	}

	public String getProperty(String name)
	{
		return properties.get(name);
	}

	public Map<String, String> getProperties()
	{
		return properties;
	}

	public String getAppletProperty(String name)
	{
		return appletProperties.get(name);
	}

	public Map<String, String> getAppletProperties()
	{
		return appletProperties;
	}
}
