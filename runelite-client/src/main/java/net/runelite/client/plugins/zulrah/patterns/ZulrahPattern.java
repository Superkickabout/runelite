/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.zulrah.patterns;

import java.util.ArrayList;
import java.util.List;
import net.runelite.client.plugins.zulrah.StandLocation;
import net.runelite.client.plugins.zulrah.ZulrahInstance;
import net.runelite.client.plugins.zulrah.ZulrahLocation;
import net.runelite.client.plugins.zulrah.ZulrahType;

public abstract class ZulrahPattern
{
	private final List<ZulrahInstance> pattern = new ArrayList<>();

	protected final void add(ZulrahLocation loc, ZulrahType type, StandLocation standLoc)
	{
		add(loc, type, standLoc, false);
	}

	protected final void addJad(ZulrahLocation loc, ZulrahType type, StandLocation standLoc)
	{
		add(loc, type, standLoc, true);
	}

	private void add(ZulrahLocation loc, ZulrahType type, StandLocation standLoc, boolean jad)
	{
		pattern.add(new ZulrahInstance(loc, type, jad, standLoc));
	}

	public ZulrahInstance get(int index)
	{
		if (index >= pattern.size())
		{
			return null;
		}

		return pattern.get(index);
	}

	public boolean stageMatches(int index, ZulrahInstance instance)
	{
		ZulrahInstance patternInstance = get(index);
		return patternInstance != null && patternInstance.equals(instance);
	}

	public boolean canReset(int index)
	{
		return index >= pattern.size();
	}
}
