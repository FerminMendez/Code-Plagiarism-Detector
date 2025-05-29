package Triple;

public class Triple
{
	private int X;
	private int Y;
	private int Z;

	public Triple()
	{
		this.X = 0;
		this.Y = 0;
		this.Z = 0;
	}

	public Triple(int x, int y, int z)
	{
		this.X = x;
		this.Y = y;
		this.Z = z;
	}

	public Triple(int total)
	{
		this.X = total / 3;
		this.Y = (total - this.X) / 2;
		this.Z = (total - this.X - this.Y);
	}

	public Boolean isValid()
	{
		if (Math.abs(this.X - this.Y) > 2)
		{
			return false;
		}
		if (Math.abs(this.X - this.Z) > 2)
		{
			return false;
		}
		if (Math.abs(this.Y - this.Z) > 2)
		{
			return false;
		}

		return true;
	}

	// A result of "True" indicates that a Triple is valid but unusual. "False"
	// could indicate invalid, or valid but not unusual (it's up to you to
	// discriminate)
	public Boolean isUnusual()
	{
		if (!this.isValid())
		{
			return false;
		}
		if (Math.abs(this.X - this.Y) > 1)
		{
			return true;
		}
		if (Math.abs(this.X - this.Z) > 1)
		{
			return true;
		}
		if (Math.abs(this.Y - this.Z) > 1)
		{
			return true;
		}

		return false;
	}

	public Boolean isHigher(int p)
	{
		Boolean high = false;
		if (this.X >= p)
		{
			high = true;
		}
		if (this.Y >= p)
		{
			high = true;
		}
		if (this.Z >= p)
		{
			high = true;
		}

		return high;
	}

	// A false response indicates either the Triple is already higher, or can't
	// be made higher without invalidating
	public Boolean couldBeHigher(int p)
	{
		Boolean high = false;
		if (this.isHigher(p))
		{
			return false;
		}
		
		if ((this.X == p - 1) && (this.X > 0))
		{
			high = true;
		}
		if ((this.Y == p - 1) && (this.Y > 0))
		{
			high = true;
		}
		if ((this.Z == p - 1) && (this.Z > 0))
		{
			high = true;
		}

		return high;
	}

	public void Unusify()
	{
		int highest = Math.max(this.X, Math.max(this.Y, this.Z));
		int lowest = Math.min(this.X, Math.min(this.Y, this.Z));
		if (this.X == highest)
		{
			this.X += 1;
			if (this.Y == lowest)
			{
				this.Z -= 1;
			} else
			{
				this.Y -= 1;
			}
		} else if (this.Y == highest)
		{
			this.Y += 1;
			if (this.X == lowest)
			{
				this.Z -= 1;
			} else
			{
				this.X -= 1;
			}
		} else
		// this.Z == highest
		{
			this.Z += 1;
			if (this.Y == lowest)
			{
				this.X -= 1;
			} else
			{
				this.Y -= 1;
			}
		}
	}

	@Override
	public String toString()
	{
		return "(" + this.X + ", " + this.Y + ", " + this.Z + ")" + (this.isUnusual() ? " is unusual" : "") + (this.isValid() ? "" : " is invalid");
	}

}
