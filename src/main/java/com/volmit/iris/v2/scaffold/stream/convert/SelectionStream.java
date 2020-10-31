package com.volmit.iris.v2.scaffold.stream.convert;

import java.util.List;

import com.volmit.iris.v2.scaffold.stream.BasicStream;
import com.volmit.iris.v2.scaffold.stream.ProceduralStream;

public class SelectionStream<T> extends BasicStream<T>
{
	private final ProceduralStream<Integer> stream;
	private final T[] options;

	public SelectionStream(ProceduralStream<?> stream, T[] options)
	{
		super();
		this.stream = stream.fit(0, options.length - 1).round();
		this.options = options;
	}

	@SuppressWarnings("unchecked")
	public SelectionStream(ProceduralStream<?> stream, List<T> options)
	{
		this(stream, (T[]) options.toArray());
	}

	@Override
	public double toDouble(T t)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T fromDouble(double d)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T get(double x, double z)
	{
		return options[stream.get(x, z)];
	}

	@Override
	public T get(double x, double y, double z)
	{
		return options[stream.get(x, y, z)];
	}

}