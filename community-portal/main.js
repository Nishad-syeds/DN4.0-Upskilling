// Welcome message
console.log("Welcome to the Community Portal");
alert("Page is fully loaded!");

// Sample event data
const events = [
  { name: "Music Night", date: "2025-06-01", category: "music", seats: 10 },
  { name: "Tech Talk", date: "2025-06-05", category: "tech", seats: 0 },
  { name: "Community Run", date: "2025-06-10", category: "sports", seats: 5 }
];

// Render events
function renderEvents() {
  const eventList = document.getElementById('eventList');
  eventList.innerHTML = '';
  events.forEach((event, index) => {
    if (new Date(event.date) > new Date() && event.seats > 0) {
      const card = document.createElement('div');
      card.className = 'col-md-4';
      card.innerHTML = `
        <div class="event-card">
          <h5>${event.name}</h5>
          <p>Date: ${event.date}</p>
          <p>Category: ${event.category}</p>
          <p>Seats Available: <span id="seats-${index}">${event.seats}</span></p>
          <button class="btn btn-sm btn-primary" onclick="register(${index})">Register</button>
        </div>`;
      eventList.appendChild(card);
    }
  });
}
renderEvents();

// Register user
function register(index) {
  try {
    if (events[index].seats > 0) {
      events[index].seats--;
      document.getElementById(`seats-${index}`).textContent = events[index].seats;
      alert(`Registered for ${events[index].name}`);
    } else {
      alert("No seats left!");
    }
  } catch (err) {
    console.error("Registration error:", err);
  }
}

// Form submission
document.getElementById('regForm').addEventListener('submit', function(e) {
  e.preventDefault();
  const form = e.target;
  const name = form.name.value;
  const email = form.email.value;
  const eventType = form.eventType.value;
  if (!name || !email || !eventType) {
    alert("All fields required!");
    return;
  }
  document.getElementById('confirmation').textContent = `Thanks, ${name}! Registered for ${eventType} event.`;
});

// Save preference
function savePreference() {
  const val = document.getElementById("eventType").value;
  localStorage.setItem("preferredEvent", val);
}

// Load saved preference
window.onload = () => {
  const saved = localStorage.getItem("preferredEvent");
  if (saved) {
    document.getElementById("eventType").value = saved;
  }
};

// Geolocation
function getLocation() {
  const loc = document.getElementById('locationDisplay');
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(
      (pos) => {
        loc.textContent = `Latitude: ${pos.coords.latitude}, Longitude: ${pos.coords.longitude}`;
      },
      (err) => {
        loc.textContent = `Error: ${err.message}`;
      },
      { enableHighAccuracy: true, timeout: 5000 }
    );
  } else {
    loc.textContent = "Geolocation not supported.";
  }
}
