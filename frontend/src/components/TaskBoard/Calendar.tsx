import React from 'react';

interface CalendarProps {
  onSelect: (date: Date) => void;
}

const Calendar: React.FC<CalendarProps> = ({ onSelect }) => {
  const dates = Array.from({ length: 30 }, (_, i) =>
    new Date(new Date().setDate(i))
  );

  return (
    <div className="calendar">
      {dates.map((date) => (
        <button
          key={date.getTime()}
          onClick={() => onSelect(date)}
          className={`day ${new Date().getMonth() === date.getMonth() ? 'selected' : ''}`}
        >
          {date.getDate()}
        </button>
      ))}
    </div>
  );
};

export default Calendar;