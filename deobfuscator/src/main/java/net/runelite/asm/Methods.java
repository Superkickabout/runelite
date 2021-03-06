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

package net.runelite.asm;

import java.util.ArrayList;
import java.util.List;
import net.runelite.asm.signature.Signature;

public class Methods
{
	private final ClassFile classFile;

	private final List<Method> methods = new ArrayList<>();
	
	Methods(ClassFile cf)
	{
		classFile = cf;
	}
	
	public void addMethod(Method m)
	{
		methods.add(m);
	}
	
	public void removeMethod(Method m)
	{
		methods.remove(m);
	}

	public ClassFile getClassFile()
	{
		return classFile;
	}
	
	public List<Method> getMethods()
	{
		return methods;
	}

	public Method findMethod(String name, Signature type)
	{
		for (Method m : methods)
			if (m.getName().equals(name) && m.getDescriptor().equals(type))
				return m;
		return null;
	}
	
	public Method findMethod(String name)
	{
		for (Method m : methods)
			if (m.getName().equals(name))
				return m;
		return null;
	}
}
