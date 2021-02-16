package collection;

import java.util.Date;
import java.util.List;

public class Course {

    private final Long uuid;

    private final String name;

    private final List<Session> sessions;

    public Course(final Long uuid, final String name, final List<Session> sessions) {
    	this.uuid = uuid;
		this.name = name;
		this.sessions = sessions;
    }
    
    private Long getUuid() {
    	return uuid;
    }

    public String getName() {
    	return name;
    }

    public List<Session> getSessions() {
		return sessions;
    }

    @Override
    public boolean equals(final Object object) {
    	// BEGIN (write your solution here)
		if(this == object) return true;
		if(object == null) return false;
		if(!(object instanceof Course)) return false;
		Course other = (Course) object;
		return this.uuid.equals(other.uuid);
        // END
    }

    public class Session {
    
    	private final Date startDate;

		Session(final Date startDate) {
			this.startDate = startDate;
		}

		Date getStartDate() {
			return this.startDate;
		}

		Course getCourse() {
			return Course.this;
		}

		@Override
		public boolean equals(final Object object) {
            // BEGIN (write your solution here)
            if(this == object) return true;
			if(object == null) return false;
			if(!(object instanceof Session)) return false;
			Session other = (Session) object;
			return this.startDate.equals(other.startDate) && Course.this.equals(other.getCourse());
            // END
        }
    }
}

