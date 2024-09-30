// TaskCalendar.tsx
import React, { useState } from 'react';
import Calendar from './Calendar';
import Task from './task';

interface TaskItem {
  id: number;
  text: string;
  completed: boolean;
  date: Date;
}

interface CalendarProps {
  title: string;
  allTasks: TaskItem[];
  onTaskChange: (id: number, completed: boolean) => void;
  onCreateTask: () => void;
}

const TaskCalendar: React.FC<CalendarProps> = ({
  title,
  allTasks,
  onTaskChange,
  onCreateTask,
}) => {
  const [selectedDate, setSelectedDate] = useState<Date | null>(null);

  const handleDateSelect = (date: Date) => {
    setSelectedDate(date);
  };

  const handleTaskToggle = (taskId: number) => {
    onTaskChange(taskId, !allTasks.find(t => t.id === taskId)?.completed || false);
  };

  const filteredTasks = allTasks.filter(task => {
    if (!task.date) return false;
  
    let startDate, endDate;
  
    if (selectedDate) {
      const year = selectedDate.getFullYear();
      const month = selectedDate.getMonth();
      startDate = new Date(year, month, 1);
      endDate = new Date(year, month + 1, 0);
      if (startDate && endDate) {
        return task.date >= startDate && task.date < endDate;
      }
    }
    return true;
  });
  

  const handleNewTaskCreation = () => {
    onCreateTask();
  };

  return (
    <div>
      <h2>{title}</h2>
      <Calendar onSelect={handleDateSelect} />
      {selectedDate && (
        <div>
          <h3>Задачи на {selectedDate.toLocaleDateString()}</h3>
          {filteredTasks.map((task) => (
            <Task
              key={task.id}
              task={task}
              onDelete={() => handleTaskToggle(task.id)}
            />
          ))}
        </div>
      )}
      <button onClick={handleNewTaskCreation}>Добавить новую задачу</button>
    </div>
  );
};

export default TaskCalendar;
